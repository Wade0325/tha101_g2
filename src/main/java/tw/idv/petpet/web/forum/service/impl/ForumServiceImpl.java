package tw.idv.petpet.web.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.forum.Repository.ForumRepository;
import tw.idv.petpet.web.forum.entity.Forum;
import tw.idv.petpet.web.forum.service.ForumService;

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

	@Override
	public void deleteArticle(Integer articleId) {
		forumRepository.deleteById(articleId);
	}

	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumRepository.findAll();
	}

//	@Override
//	public void deleteArticle(int articleId) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void updateForum(int articleId, Integer articleGroupId, String articleTitle, String articleContent) {
//		// TODO Auto-generated method stub
//		forumRepository.updateForum(articleId, articleGroupId, 
//				articleTitle, articleContent);
//	}

}
