package com.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.ReportFirmEntity;

@Repository
public interface ReportFirmRepository extends JpaRepository<ReportFirmEntity, Integer> {
	ReportFirmEntity findByFirmSn(Integer firmSn);
	List<ReportFirmEntity> findByConfirmCode(String confirmCode);
	@Query(value = "SELECT * FROM report_firm WHERE date(firm_date) BETWEEN ?1 AND ?2", nativeQuery = true)
	Optional<List<ReportFirmEntity>> findByFirmDate(String startDate, String endDate);
}
