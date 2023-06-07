package tw.idv.petpet.web.clinic.clinicAppointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.naming.ImplicitNameSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;
import tw.idv.petpet.web.clinic.businessDate.repository.BusinessDateRepository;
import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.repository.ClinicAppointmentRepository;

@Service
@Transactional
public class ClinicAppointmentService {

	@Autowired
	private ClinicAppointmentRepository clinicAppointmentRepository;

	@Autowired
	private BusinessDateRepository businessDateRepository;

	public void save(ClinicAppointment clinicAppointment) {
		BusinessDate businessDate = businessDateRepository
				.findByWeekDateAndClinicName(clinicAppointment.getAppointDate(), clinicAppointment.getClinicName());

//		if (businessDate != null && clinicAppointment.getClinicName().equals(businessDate.getClinicName())) {
//			if (businessDate.getWeekDate().equals(clinicAppointment.getAppointDate())) {
//				int morningAppointMax = businessDate.getMorningAppointMax(); // 早上時段
//				if (morningAppointMax > 0) {
//
//					clinicAppointmentRepository.save(clinicAppointment); // 進行預約操作
//					System.out.println("早上時段預約成功");
//					businessDate.setMorningAppointMax(morningAppointMax - 1); // 更新可預約人數
//
//					System.out.println("早上時段預約人數更新成功");
//					businessDateRepository.save(businessDate);
//				} else {
//					System.out.println("預約失敗，人數已滿");
//				}
//			} else {
//				System.out.println("預約失敗，預約日期匹配錯誤");
//			}
//		} else {
//			System.out.println("預約失敗，當日未營業或診所名稱錯誤或同時段重複預約");
//		}

		String appointTime = clinicAppointment.getAppointTime();
		if (businessDate != null && clinicAppointment.getClinicName().equals(businessDate.getClinicName())) {
			if (appointTime.equals("上午")) {
				int morningAppointMax = businessDate.getMorningAppointMax(); // 抓取早上預約人數
				if (morningAppointMax > 0) { // 預約名額大於零進行預約操作
					clinicAppointmentRepository.save(clinicAppointment);
					System.out.println(clinicAppointment.getClinicName() + "診所上午時段預約成功");

					businessDate.setMorningAppointMax(morningAppointMax - 1); // 更新可預約人數
					businessDateRepository.save(businessDate);
					System.out.println(clinicAppointment.getClinicName() + "診所上午時段預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所上午時段預約人數已滿預約失敗");
				}
			} else if (appointTime.equals("下午")) {
				int afternoonAppointMax = businessDate.getAfternoonAppointMax(); // 抓取下午預約人數
				if (afternoonAppointMax > 0) {
					clinicAppointmentRepository.save(clinicAppointment);
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段預約成功");

					businessDate.setAfternoonAppointMax(afternoonAppointMax - 1); // 更新可預約人數
					businessDateRepository.save(businessDate);
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段預約人數已滿預約失敗");
				}
			} else if (appointTime.equals("晚上")) {
				int nightAppointMax = businessDate.getNightAppointMax(); // 抓取晚上預約人數
				if (nightAppointMax > 0) {
					clinicAppointmentRepository.save(clinicAppointment);
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段預約成功");

					businessDate.setNightAppointMax(nightAppointMax - 1);// 更新可預約人數
					businessDateRepository.save(businessDate);
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段預約人數已滿預約失敗");
				}
			}
		} else {
			System.out.println("預約失敗，當日未營業或診所名稱錯誤");
		}
	}

	public void update(Integer reservationNumber, ClinicAppointment clinicAppointment) {
		ClinicAppointment clinicAppointment1 = clinicAppointmentRepository.findById(reservationNumber).orElse(null);
		// clinicId不可修改
		if (clinicAppointment1 != null) {
			clinicAppointment1.setClinicName(clinicAppointment.getClinicName());
			clinicAppointment1.setVetName(clinicAppointment.getVetName());
			clinicAppointment1.setAppointDate(clinicAppointment.getAppointDate());
			clinicAppointment1.setAppointTime(clinicAppointment.getAppointTime());
			clinicAppointment1.setOwnerMobile(clinicAppointment.getOwnerMobile());
			clinicAppointment1.setPetType(clinicAppointment.getPetType());
			clinicAppointment1.setPetName(clinicAppointment.getPetName());
			clinicAppointment1.setServiceItem(clinicAppointment.getServiceItem());
			clinicAppointment1.setOwnerName(clinicAppointment.getOwnerName());
			clinicAppointment1.setPetSituation(clinicAppointment.getPetSituation());
			clinicAppointmentRepository.save(clinicAppointment1);
		}
	}

	public Optional<ClinicAppointment> findByReservationNumber(Integer reservationNumber) {
		return clinicAppointmentRepository.findById(reservationNumber);
	}

	public void deleteById(Integer reservationNumber) {

		Optional<ClinicAppointment> clinicAppointment = clinicAppointmentRepository.findById(reservationNumber);

		if (clinicAppointment.isPresent()) {
			ClinicAppointment clinicAppointment1 = clinicAppointment.get();
			LocalDate appointDate = clinicAppointment1.getAppointDate(); // 日期
			String clinicName = clinicAppointment1.getClinicName();
			String appointTime = clinicAppointment1.getAppointTime(); // 時段
			BusinessDate businessDate = businessDateRepository.findByWeekDateAndClinicName(appointDate, clinicName);

			if (businessDate != null && clinicAppointment1.getClinicName().equals(businessDate.getClinicName())) {
				if (appointTime.equals("上午")) {
					int morningAppointMax = businessDate.getMorningAppointMax(); // 抓取早上预约人数
					businessDate.setMorningAppointMax(morningAppointMax + 1); // 将预约人数加回来
					businessDateRepository.save(businessDate); // 更新可预约人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 删除预约记录
					System.out.println("删除成功，预约号：" + reservationNumber);
				} else if (appointTime.equals("下午")) {
					int afternoonAppointMax = businessDate.getAfternoonAppointMax(); // 抓取下午预约人数
					businessDate.setAfternoonAppointMax(afternoonAppointMax + 1); // 将预约人数加回来
					businessDateRepository.save(businessDate); // 更新可预约人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 删除预约记录
					System.out.println("删除成功，预约号：" + reservationNumber);
				} else if (appointTime.equals("晚上")) {
					int nightAppointMax = businessDate.getNightAppointMax(); // 抓取晚上预约人数
					businessDate.setNightAppointMax(nightAppointMax + 1); // 将预约人数加回来
					businessDateRepository.save(businessDate); // 更新可预约人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 删除预约记录
					System.out.println("删除成功，预约号：" + reservationNumber);
				}
			} else {
				System.out.println("预约失败，当日未营业或诊所名称错误");
			}
		}
	}
	
//	Optional<ClinicAppointment> clinicAppointment = clinicAppointmentRepository.findById(reservationNumber);
//
//	if (clinicAppointment.isPresent()) {
//		ClinicAppointment clinicAppointment1 = clinicAppointment.get();
//		LocalDate appointDate = clinicAppointment1.getAppointDate();
//		String clinicName = clinicAppointment1.getClinicName();
//		String appointTime = clinicAppointment1.getAppointTime();
//		BusinessDate businessDate = businessDateRepository.findByWeekDateAndClinicName(appointDate, clinicName);
//		System.out.println("1");
//		if (businessDate != null) {
//			System.out.println("2");
//			if (businessDate.getMorningBusiness().equals(appointTime)) {
//				int morningAppointMax = businessDate.getMorningAppointMax();
//				System.out.println("3");
//				businessDate.setMorningAppointMax(morningAppointMax + 1);
//				System.out.println("4");
//				businessDateRepository.save(businessDate);
//				System.out.println("5");
//				clinicAppointmentRepository.deleteById(reservationNumber);
//				System.out.println("6");
//			}
//		}
//	}


	public List<ClinicAppointment> listAll() {
		return clinicAppointmentRepository.findAll();
	}

	public List<ClinicAppointment> findByClinicName(String clinicName) {
		return clinicAppointmentRepository.findByClinicName(clinicName);
	}
}
