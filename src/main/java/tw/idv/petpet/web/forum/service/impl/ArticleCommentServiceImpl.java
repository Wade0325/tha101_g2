package tw.idv.petpet.web.forum.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.forum.Repository.ArticleCommentRepository;
import tw.idv.petpet.web.forum.entity.ArticleComment;
import tw.idv.petpet.web.forum.service.ArticleCommentService;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService{

	@Autowired
    private ArticleCommentRepository articleCommentRepository;
	
	@Override
	public void replyArticle(int articleId, ArticleComment articleComment) {
		// TODO Auto-generated method stub
		System.out.print("回覆文章成功，進入ArticleCommentServiceImpl層");
		articleComment.setArticleId(articleId);
		articleComment.setReplyTime(new Date());
		
		articleCommentRepository.save(articleComment);
		
	}

//	@Override
//	public ArticleComment findByArticleId(Integer articleId) {
//		// TODO Auto-generated method stub
//		System.out.println("透過文章ID，找到文章內容");
//		return articleCommentRepository.findByArticleId(articleId);
//	}

	@Override
	public List<ArticleComment> findByArticleId(Integer articleId) {
		// TODO Auto-generated method stub
		System.out.println("透過文章ID，找到文章內容");
		return articleCommentRepository.findByArticleId(articleId);
	}

}
