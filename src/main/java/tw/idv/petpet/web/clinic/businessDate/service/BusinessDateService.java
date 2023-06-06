package tw.idv.petpet.web.clinic.businessDate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;
import tw.idv.petpet.web.clinic.businessDate.repository.BusinessDateRepository;

@Service
@Transactional
public class BusinessDateService {

	@Autowired
	private BusinessDateRepository businessDateRepository;

	public void save(BusinessDate businessDate) {
		businessDateRepository.save(businessDate);
	}

	public void update(Integer businessSn, BusinessDate businessDate) {
		BusinessDate businessDate1 = businessDateRepository.findById(businessSn).orElse(null);
		// businessSn不可修改
		if (businessDate1 != null) {
			businessDate1.setClinicName(businessDate.getClinicName());
			businessDate1.setVetSn(businessDate.getVetSn());
			businessDate1.setWeekDate(businessDate.getWeekDate());
			businessDate1.setMorningBusiness(businessDate.getMorningBusiness());
			businessDate1.setMorningAppointMax(businessDate.getMorningAppointMax());
			businessDate1.setAfternoonBusiness(businessDate.getAfternoonBusiness());
			businessDate1.setAfternoonAppointMax(businessDate.getAfternoonAppointMax());
			businessDate1.setNightBusiness(businessDate.getNightBusiness());
			businessDate1.setNightAppointMax(businessDate.getNightAppointMax());
			businessDateRepository.save(businessDate1);
		}
	}

	public Optional<BusinessDate> findById(Integer businessSn) {
		return businessDateRepository.findById(businessSn);
	}

	public void deleteById(Integer businessSn) {
		businessDateRepository.deleteById(businessSn);
	}

	public List<BusinessDate> listAll() {
		return businessDateRepository.findAll();
	}
}
