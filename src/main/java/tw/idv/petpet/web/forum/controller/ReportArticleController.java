package tw.idv.petpet.web.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.forum.entity.ReportArticle;
import tw.idv.petpet.web.forum.service.ReportArticleService;

@RestController
@RequestMapping("/forum/report_article")
public class ReportArticleController {
	
	private final ReportArticleService reportArticleService;

	@Autowired
	public ReportArticleController(ReportArticleService reportArticleService) {
		this.reportArticleService = reportArticleService;
	}

	@PostMapping
	public ResponseEntity<ReportArticle> createReportArticle(@RequestBody ReportArticle reportArticle) {
		System.out.println("ReportArticleController: createReportArticle");
		
		ReportArticle savedReportArticle = reportArticleService.saveReportArticle(reportArticle);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedReportArticle);
	}

	@GetMapping("/{reportId}")
	public ResponseEntity<ReportArticle> getReportArticleById(@PathVariable Integer reportId) {
		System.out.println("ReportArticleController: getReportArticleById");
		ReportArticle reportArticle = reportArticleService.getReportArticleById(reportId);
		return ResponseEntity.ok(reportArticle);
	}
}
