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
	
	public Optional<BusinessDate> findById(Integer businessSn) {
		return businessDateRepository.findById(businessSn);
	}
	
	public void deleteById(Integer businessSn) {
		businessDateRepository.deleteById(businessSn);
	}
	
	public List<BusinessDate> listAll(){
		return businessDateRepository.findAll();
	}
}
