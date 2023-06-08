package tw.idv.petpet.web.forum.service;

import tw.idv.petpet.web.forum.entity.ReportArticle;

public interface ReportArticleService {
	ReportArticle saveReportArticle(ReportArticle reportArticle);

	ReportArticle getReportArticleById(Integer reportId);
}
