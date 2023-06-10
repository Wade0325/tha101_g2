package tw.idv.petpet.web.forum.service;

import java.util.List;

import tw.idv.petpet.web.forum.entity.ArticleComment;

public interface ArticleCommentService {
	
	void replyArticle(int articleId, ArticleComment articleComment);
	
//	ArticleComment findByArticleId(Integer articleId);
	
	List<ArticleComment> findByArticleId(Integer articleId);
}
