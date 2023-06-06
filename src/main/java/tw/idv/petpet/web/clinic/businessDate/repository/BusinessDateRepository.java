package tw.idv.petpet.web.clinic.businessDate.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;

public interface BusinessDateRepository extends JpaRepository<BusinessDate, Integer>{

	BusinessDate findByWeekDateAndClinicName(Date appointDate, String clinicName); //找預約日及診所名稱

}
