package tw.idv.petpet.web.forum.service;

import java.util.List;

import tw.idv.petpet.web.forum.entity.ArticleComment;
import tw.idv.petpet.web.user.entity.User;

public interface ArticleCommentService {
	
	void replyArticle(int articleId, User user ,ArticleComment articleComment);
	
//	ArticleComment findByArticleId(Integer articleId);
	
	List<ArticleComment> findByArticleId(Integer articleId);
	
	
}
