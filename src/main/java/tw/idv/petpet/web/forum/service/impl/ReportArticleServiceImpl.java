package tw.idv.petpet.web.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.forum.Repository.ReportArticleRepository;
import tw.idv.petpet.web.forum.entity.ReportArticle;
import tw.idv.petpet.web.forum.service.ReportArticleService;

@Service("ReportArticleService")
public class ReportArticleServiceImpl implements ReportArticleService {

	private final ReportArticleRepository reportArticleRepository;

	@Autowired
	public ReportArticleServiceImpl(ReportArticleRepository reportArticleRepository) {
		this.reportArticleRepository = reportArticleRepository;
	}

	@Override
	public ReportArticle saveReportArticle(ReportArticle reportArticle) {
		// TODO Auto-generated method stub
		System.out.println("saveReportArticle");
		return reportArticleRepository.save(reportArticle);
	}

	@Override
	public ReportArticle getReportArticleById(Integer reportId) {
		// TODO Auto-generated method stub
		System.out.println("getReportArticleById");
		return reportArticleRepository.findById(reportId)
				.orElseThrow(() -> new IllegalArgumentException("Report Article not found"));
	}

}
