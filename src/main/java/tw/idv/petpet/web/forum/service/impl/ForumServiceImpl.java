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
		return forumRepository.findById(articleId).orElse(null);
	}

	@Override
	    public void deleteForum(Integer articleId) {
	        forumRepository.deleteById(articleId);
	    }

	@Override
	public List<Forum> getAllArticles() {
		//獲取所有的文章
		return forumRepository.findAll();
	}
}
