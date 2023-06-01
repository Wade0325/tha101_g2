package tw.idv.petpet.web.clinicMember.Repository;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.clinicMember.entity.PriceList;
import java.util.List;


public interface PriceListRespository extends CrudRepository<PriceList, Integer>{

	 List<PriceList> findByClinicServiceName(String clinicServiceName);
	 PriceList findByClinicServiceIdAndClinicServiceName(int clinicServiceId, String ClinicServiceName);
	 List<PriceList> findAll();
}
