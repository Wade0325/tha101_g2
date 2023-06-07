package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.ReportFirmEntity;
import com.web.repository.ReportFirmRepository;

import dto.ReportFirmCodeVO;

@RestController
public class SearchByCodeReportFirm {
	@Autowired
	private ReportFirmRepository reportFirmRepository;
	@PostMapping("/getreportfirmbycode")
	public List<ReportFirmEntity> getReportFirmByCode(@RequestBody ReportFirmCodeVO reportFirmCodeVO) {
		System.out.println(reportFirmCodeVO.getConfirmCode());
		List<ReportFirmEntity> reportFirmEntity = reportFirmRepository.findByConfirmCode(reportFirmCodeVO.getConfirmCode());
		System.out.println(reportFirmEntity);
		return reportFirmEntity;
	}
}
