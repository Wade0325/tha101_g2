package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.ReportArticleEntity;

@Repository
public interface ReportArticleRepository extends JpaRepository<ReportArticleEntity, Integer> {

}
