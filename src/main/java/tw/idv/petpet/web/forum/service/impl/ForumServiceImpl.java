package tw.idv.petpet.web.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.forum.Repository.ForumRepository;
import tw.idv.petpet.web.forum.entity.Forum;
import tw.idv.petpet.web.forum.service.ForumService;

@Transactional
@Service("ForumService")
public class ForumServiceImpl implements ForumService {

	private final ForumRepository forumRepository;

	@Autowired
	public ForumServiceImpl(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	@Override
	public Forum createForum(Forum forum) {
			System.out.print("發表文章成功,進入ForumServiceImpl層");
			return forumRepository.save(forum);
	}

	@Override
	public Forum findByArticleId(Integer articleId) {
		System.out.println("透過文章ID，找到文章內容");
		return forumRepository.findByArticleId(articleId);
	}

//	@Override run ok
//	public Forum findByArticleId(int articleId) {
//		System.out.println("透過文章ID，找到文章內容");
//		return forumRepository.findById(articleId).orElse(null);
//	}

//	@Override
//	public void deleteArticle(Integer articleId) {
//		forumRepository.deleteById(articleId);
//	}

	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumRepository.findAll();
	}

	@Override
	public Forum updateArticleContent(String articleContent, Integer articleId) {
		Forum existingForum = forumRepository.findByArticleId(articleId);
		if (existingForum != null) {
			System.out.println("修改文章成功，返回文章頁面");
			existingForum.setArticleContent(articleContent);
			Forum updateForum = forumRepository.save(existingForum);
			return updateForum;
		}
		return null;
	}

	@Override
	public void deleteArticleByArticleId(Integer articleId) {
		forumRepository.deleteArticle(articleId);
		System.out.println("刪除文章成功");
		forumRepository.deleteArticleByArticleId(articleId);
	}


}
