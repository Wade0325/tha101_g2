package tw.idv.petpet.web.forum.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumService extends CoreService {

	public Forum createForum(Forum forum);

//	public Forum findByArticleId(int articleId);

	Forum findByArticleId(Integer articleId);

	void deleteArticleByArticleId(Integer articleId);

	List<Forum> findAll();

//	void updateForum(Forum forum);
	
	Forum updateArticleContent(String articleContent, Integer articleId);
	
//	void updateForum(int articleId, Integer articleGroupId ,
//			String articleTitle, String articleContent);
}
