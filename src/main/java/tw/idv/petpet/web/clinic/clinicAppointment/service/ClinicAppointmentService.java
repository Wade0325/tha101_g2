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

		if (businessDate != null && clinicAppointment.getClinicName().equals(businessDate.getClinicName())) {
			if (businessDate.getWeekDate().equals(clinicAppointment.getAppointDate())) {
				int morningAppointMax = businessDate.getMorningAppointMax(); // 早上時段
				if (morningAppointMax > 0) {

					clinicAppointmentRepository.save(clinicAppointment); // 進行預約操作
					System.out.println("早上時段預約成功");
					businessDate.setMorningAppointMax(morningAppointMax - 1); // 更新可預約人數

					System.out.println("早上時段預約人數更新成功");
					businessDateRepository.save(businessDate);
				} else {
					System.out.println("預約失敗，人數已滿");
				}
			} else {
				System.out.println("預約失敗，預約日期匹配錯誤");
			}
		} else {
			System.out.println("預約失敗，當日未營業或診所名稱錯誤或同時段重複預約");
		}

		if (businessDate != null && clinicAppointment.getClinicName().equals(businessDate.getClinicName())) {
			if (businessDate.getWeekDate().equals(clinicAppointment.getAppointDate())) {
				int afternoonAppointMax = businessDate.getAfternoonAppointMax(); // 下午時段
				if (afternoonAppointMax > 0) {

					clinicAppointmentRepository.save(clinicAppointment); // 進行預約操作
					System.out.println("下午時段預約成功");

					businessDate.setAfternoonAppointMax(afternoonAppointMax - 1); // 更新可預約人數
					System.out.println("下午時段預約人數更新成功");
					businessDateRepository.save(businessDate);
				} else {
					System.out.println("預約失敗，人數已滿");
				}
			} else {
				System.out.println("預約失敗，預約日期匹配錯誤");
			}
		} else {
			System.out.println("預約失敗，當日未營業或診所名稱錯誤或同時段重複預約");
		}

		if (businessDate != null && clinicAppointment.getClinicName().equals(businessDate.getClinicName())) {
			if (businessDate.getWeekDate().equals(clinicAppointment.getAppointDate())) {
				int nightAppointMax = businessDate.getNightAppointMax(); // 晚上時段
				if (nightAppointMax > 0) {

					clinicAppointmentRepository.save(clinicAppointment); // 進行預約操作
					System.out.println("晚上時段預約成功");

					businessDate.setNightAppointMax(nightAppointMax - 1); // 更新可預約人數
					System.out.println("晚上時段預約人數更新成功");
					businessDateRepository.save(businessDate);
				} else {
					System.out.println("預約失敗，人數已滿");
				}
			} else {
				System.out.println("預約失敗，預約日期匹配錯誤");
			}
		} else {
			System.out.println("預約失敗，當日未營業或診所名稱錯誤或同時段重複預約");
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
			LocalDate appointDate = clinicAppointment1.getAppointDate();
			String clinicName = clinicAppointment1.getClinicName();
			String appointTime = clinicAppointment1.getAppointTime();

			BusinessDate businessDate = businessDateRepository.findByWeekDateAndClinicName(appointDate, clinicName);

			if (businessDate != null) {
				if (businessDate.getMorningBusiness().equals(appointTime)) {
					int morningAppointMax = businessDate.getMorningAppointMax();
					businessDate.setMorningAppointMax(morningAppointMax + 1);

					businessDateRepository.save(businessDate);

					clinicAppointmentRepository.deleteById(reservationNumber);
				}
			}
		}

		if (clinicAppointment.isPresent()) {
			ClinicAppointment clinicAppointment1 = clinicAppointment.get();
			LocalDate appointDate = clinicAppointment1.getAppointDate();
			String clinicName = clinicAppointment1.getClinicName();
			String appointTime = clinicAppointment1.getAppointTime();

			BusinessDate businessDate = businessDateRepository.findByWeekDateAndClinicName(appointDate, clinicName);

			if (businessDate != null) {
				if (businessDate.getAfternoonBusiness().equals(appointTime)) {
					int afternoonAppointMax = businessDate.getAfternoonAppointMax();
					businessDate.setAfternoonAppointMax(afternoonAppointMax + 1);

					businessDateRepository.save(businessDate);

					clinicAppointmentRepository.deleteById(reservationNumber);
				}
			}
		}

		if (clinicAppointment.isPresent()) {
			ClinicAppointment clinicAppointment1 = clinicAppointment.get();
			LocalDate appointDate = clinicAppointment1.getAppointDate();
			String clinicName = clinicAppointment1.getClinicName();
			String appointTime = clinicAppointment1.getAppointTime();

			BusinessDate businessDate = businessDateRepository.findByWeekDateAndClinicName(appointDate, clinicName);

			if (businessDate != null) {
				if (businessDate.getNightBusiness().equals(appointTime)) {
					int nightAppointMax = businessDate.getNightAppointMax();
					businessDate.setNightAppointMax(nightAppointMax + 1);

					businessDateRepository.save(businessDate);

					clinicAppointmentRepository.deleteById(reservationNumber);
				}
			}
		}
	}

	public List<ClinicAppointment> listAll() {
		return clinicAppointmentRepository.findAll();
	}

	public List<ClinicAppointment> findByClinicName(String clinicName) {
		return clinicAppointmentRepository.findByClinicName(clinicName);
	}
}
