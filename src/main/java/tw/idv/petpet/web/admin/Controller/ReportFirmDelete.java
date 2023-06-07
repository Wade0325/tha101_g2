package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.repository.ReportFirmRepository;

@RestController
public class ReportFirmDelete {
	@Autowired
	private ReportFirmRepository reportFirmRepository;

	@DeleteMapping("reportfirm/delete")
	public void delete(@RequestParam Integer firmSn) {
		System.out.println("刪除開始");
		reportFirmRepository.deleteById(firmSn);
	}
}
