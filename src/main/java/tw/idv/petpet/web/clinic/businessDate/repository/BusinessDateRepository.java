package tw.idv.petpet.web.clinic.businessDate.repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;

public interface BusinessDateRepository extends JpaRepository<BusinessDate, Integer>{

	BusinessDate findByWeekDateAndClinicName(LocalDate appointDate, String clinicName); //找預約日及診所名稱

}
