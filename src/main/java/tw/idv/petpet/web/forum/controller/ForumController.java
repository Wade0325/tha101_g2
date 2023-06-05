package tw.idv.petpet.web.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		// 檢查用戶是否已登錄

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
		return "執行Create操作";
	}

	// 獲取所有文章的方法
	@GetMapping("/forum")
	public List<Forum> getAllArticles() {
		return forumService.getAllArticles();
	}

//	@GetMapping("/forum/{id}")
//	public String viewForum(@PathVariable("id") Integer articleId, Model model) {
//		Forum forum = forumService.findByArticleId(articleId);
//		model.addAttribute("forum", forum);
//		return "forum-details";
//	}
//
//	@DeleteMapping("/forum/{id}")
//	public String deleteForum(@PathVariable("id") Integer articleId) {
//		forumService.deleteForum(articleId);
//		// 其他处理逻辑...
//		return "redirect:/forums";
//	}

}
