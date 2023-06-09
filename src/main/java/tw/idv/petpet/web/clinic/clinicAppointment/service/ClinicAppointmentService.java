package tw.idv.petpet.web.clinic.clinicAppointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
					
					clinicAppointment.setMessage("預約成功");
					clinicAppointment.setSuccessful(true);
					System.out.println(clinicAppointment.getClinicName() + "診所上午時段可預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所上午時段預約人數已滿預約失敗或未營業");
				}
			} else if (appointTime.equals("下午")) {
				int afternoonAppointMax = businessDate.getAfternoonAppointMax(); // 抓取下午預約人數
				if (afternoonAppointMax > 0) {
					clinicAppointmentRepository.save(clinicAppointment);
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段預約成功");

					businessDate.setAfternoonAppointMax(afternoonAppointMax - 1); // 更新可預約人數
					businessDateRepository.save(businessDate);
					
					clinicAppointment.setMessage("預約成功");
					clinicAppointment.setSuccessful(true);
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段可預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所下午時段預約人數已滿預約失敗或未營業");
				}
			} else if (appointTime.equals("晚上")) {
				int nightAppointMax = businessDate.getNightAppointMax(); // 抓取晚上預約人數
				if (nightAppointMax > 0) {
					clinicAppointmentRepository.save(clinicAppointment);
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段預約成功");

					businessDate.setNightAppointMax(nightAppointMax - 1);// 更新可預約人數
					businessDateRepository.save(businessDate);
					
					clinicAppointment.setMessage("預約成功");
					clinicAppointment.setSuccessful(true);
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段可預約人數更新成功");
				} else {
					System.out.println(clinicAppointment.getClinicName() + "診所晚上時段預約人數已滿預約失敗或未營業");
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
			clinicAppointment1.setPayInfo(clinicAppointment.getPayInfo());
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
					int morningAppointMax = businessDate.getMorningAppointMax(); // 抓取早上預約人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 刪除早上預約紀錄
					System.out.println(clinicAppointment1.getOwnerName() + "在" + clinicName + "早上預約取消");

					businessDate.setMorningAppointMax(morningAppointMax + 1); // 將可預約人數加回
					businessDateRepository.save(businessDate); // 更新可預約人數
					System.out.println(businessDate.getClinicName() + "診所早上可預約人數更新成功");

				} else if (appointTime.equals("下午")) {
					int afternoonAppointMax = businessDate.getAfternoonAppointMax(); // 抓取下午預約人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 刪除下午預約紀錄
					System.out.println(clinicAppointment1.getOwnerName() + "在" + clinicName + "下午預約取消");

					businessDate.setAfternoonAppointMax(afternoonAppointMax + 1); // 將可預約人數加回
					businessDateRepository.save(businessDate); // 更新可預約人數
					System.out.println(businessDate.getClinicName() + "診所下午可預約人數更新成功");

				} else if (appointTime.equals("晚上")) {
					int nightAppointMax = businessDate.getNightAppointMax(); // 抓取晚上預約人数

					clinicAppointmentRepository.deleteById(reservationNumber); // 刪除晚上預約紀錄
					System.out.println(clinicAppointment1.getOwnerName() + "在" + clinicName + "晚上預約取消");

					businessDate.setNightAppointMax(nightAppointMax + 1); // 將可預約人數加回
					businessDateRepository.save(businessDate); // 更新可預約人數
					System.out.println(businessDate.getClinicName() + "診所晚上可預約人數更新成功");
				}
			} else {
				clinicAppointmentRepository.deleteById(reservationNumber);
				System.out.println("預約錯誤直接刪除");
			}
		}
	}

	public List<ClinicAppointment> listAll() {
		return clinicAppointmentRepository.findAll();
	}

	public List<ClinicAppointment> findByClinicName(String clinicName) {
		return clinicAppointmentRepository.findByClinicName(clinicName);
	}
	
	public List<ClinicAppointment> findByOwnerName(String ownerName) {
		return clinicAppointmentRepository.findByOwnerName(ownerName);
	}
}
