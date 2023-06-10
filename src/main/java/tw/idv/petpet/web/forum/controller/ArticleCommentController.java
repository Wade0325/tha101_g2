package tw.idv.petpet.web.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.forum.entity.ArticleComment;
import tw.idv.petpet.web.forum.service.ArticleCommentService;

@RestController
@RequestMapping("/forum")
public class ArticleCommentController {

	@Autowired
	ArticleCommentService articleCommentService;

	@PostMapping("/reply/{articleId}")
	public void replyArticle(@PathVariable int articleId, @RequestBody ArticleComment articleComment) {
		// 调用 ArticleCommentService 处理回复文章的逻辑
		articleCommentService.replyArticle(articleId, articleComment);
	}

//	@GetMapping("article_cat/{articleId}")
//	public ArticleComment findByArticleId(@PathVariable Integer articleId) {
//		System.out.println("ArticleCommentController 開始執行");
//		ArticleComment findArticleId = articleCommentService.findByArticleId(articleId);
//		System.out.println("查看是否獲取Id" + articleId);
//		return findArticleId;
//	}
	
	@GetMapping("article_cat/{articleId}")
	public List<ArticleComment> findByArticleId(@PathVariable Integer articleId) {
		System.out.println("ArticleCommentController 開始執行");
		List<ArticleComment> findArticleIdAll = articleCommentService.findByArticleId(articleId);
		System.out.println("查看是否獲取Id" + articleId);
		return findArticleIdAll;
	}

}
