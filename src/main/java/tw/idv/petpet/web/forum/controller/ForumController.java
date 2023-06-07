package tw.idv.petpet.web.forum.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.forum.entity.Forum;
import tw.idv.petpet.web.forum.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {

	private final ForumService forumService;

	@Autowired
	public ForumController(ForumService forumService) {
		this.forumService = forumService;
	}

	@PostMapping("/publish") // @ModelAttribute("forum") Forum forum
	public String createForum(@ModelAttribute("forum") Forum forum) {
		// 檢查用戶是否已登錄 ?? -> 还没用
		forum.setArticleCreateTime(new Date());

		System.out.println("articleId" + forum.getArticleId());
		System.out.println("userId" + forum.getUserId());
		System.out.println("articleGroupId" + forum.getArticleGroupId());
		System.out.println("articleTitle" + forum.getArticleTitle());
		System.out.println("articleContent" + forum.getArticleContent());
		System.out.println("articleImage" + forum.getArticleImage());
		System.out.println("articleCreateTime" + forum.getArticleCreateTime());
		System.out.println("articleModiferTime" + forum.getModifierTime());
		System.out.println("articleStatus" + forum.getArticleStatus());

		System.out.print("發表文章成功,進入ForumController層");
//		Forum createdForum = 
		forumService.createForum(forum);
		System.out.println("我在createdForum下面");

		// 其他处理逻辑...
		return "執行了create操作";
	}

	@GetMapping("/forum")
	public List<Forum> findAll() {
		System.out.println("文章列表查詢成功");
		return forumService.findAll();
	}

//	@GetMapping("/article_cat/{articleId}")
//	public Forum findByArticleId(@PathVariable("articleId") int articleId, @RequestBody Forum forum) {
//		System.out.println("controller層：findByArticleId有被呼叫到");
//		return forumService.findByArticleId(articleId);
//	}

	@GetMapping("/article_cat/{articleId}")
	public ResponseEntity<Forum> getArticleById(@PathVariable("articleId") int articleId) {
		Forum forum = forumService.findByArticleId(articleId);
		if (forum != null) {
			return ResponseEntity.ok(forum);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	// 獲取所有文章的方法
//	@GetMapping("/forum")
//	public List<Forum> getAllArticles() {
//		List<Forum> forum = forumService.getAllArticles();
//		System.out.println("獲取所有的文章");
//		return forum;
//	}

//	@GetMapping("/forum/{id}")
//	public String viewForum(@PathVariable("id") Integer articleId, Model model) {
//		Forum forum = forumService.findByArticleId(articleId);
//		model.addAttribute("forum", forum);
//		System.out.println("viewForum方法");
//		return "forum-details";
//	}
//
//	@DeleteMapping("/forum/{id}")
//	public String deleteArticle(@PathVariable("id") Integer articleId) {
//		forumService.deleteArticle(articleId);
//		// 其他处理逻辑...
//		return "redirect:/forum.html";
//	}

}
