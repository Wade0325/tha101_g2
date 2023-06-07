package com.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.ReportUserEntity;

@Repository
public interface ReportUserRepository extends JpaRepository<ReportUserEntity, Integer> {
	
	List<ReportUserEntity>findAll();
	@Query(value = "SELECT * FROM report_user WHERE date(user_date) BETWEEN ?1 AND ?2", nativeQuery = true)
	Optional<List<ReportUserEntity>> findByUserDate(String startDate, String endDate);
}
