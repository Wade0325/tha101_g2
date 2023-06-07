package tw.idv.petpet.web.forum.service;

import java.util.List;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumService extends CoreService{

	public Forum createForum(Forum forum);
	
	public Forum findByArticleId(Integer articleId);
	
	void deleteArticle(Integer articleId);
	
	 List<Forum> findAll();
	
//	void updateForum(int articleId, Integer articleGroupId ,
//			String articleTitle, String articleContent);
}
