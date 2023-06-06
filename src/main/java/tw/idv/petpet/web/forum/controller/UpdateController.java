//package tw.idv.petpet.web.forum.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import tw.idv.petpet.web.forum.service.ForumService;
//
//@RestController
//@RequestMapping("/forum")
//public class UpdateController {
//
//	private final ForumService forumService;
//
//	@Autowired
//	public UpdateController(ForumService forumService) {
//		this.forumService = forumService;
//	}
//
//	@PostMapping("/update")
//	public String updateForum(@RequestParam("articleId") int articleId,
//			@RequestParam("articleGroupId") Integer articleGroupId, @RequestParam("articleTitle") String articleTitle,
//			@RequestParam("articleContent") String articleContent) {
//		// 调用 ForumService 中的更新方法
//		forumService.updateForum(articleId, articleGroupId, articleTitle, articleContent);
//
//		// 其他处理逻辑...
//		return "执行更新操作";
//	}
//
//}
