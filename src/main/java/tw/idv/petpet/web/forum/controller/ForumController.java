package tw.idv.petpet.web.forum.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.forum.entity.Forum;
import tw.idv.petpet.web.forum.service.ForumService;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	ForumService forumService;

	@Autowired
	UserService userService;

	@PostMapping("/publish") // @ModelAttribute("forum") Forum forum
	public void createForum(@ModelAttribute("forum") Forum forum, HttpSession session, HttpServletResponse response) {
		// 檢查用戶是否已登錄
		User userSession = (User) session.getAttribute("userAccount");
		if (userSession.isLogin()) {
			// 用戶已經登錄，可以發表文章
			forum.setArticleCreateTime(new Date());
			System.out.print("發表文章成功,進入ForumController層");
			forum.setUserId(userSession.getUserId());
			forumService.createForum(forum);
			System.out.println("userId" + forum.getUserId());
			System.out.println("我在createdForum下面");
			try {
				response.sendRedirect("http://localhost:8080/petpet/forum/forum.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 用戶未登錄，返回錯誤訊息或進行跳轉的動作
			System.out.println("請登錄！！");
		}
	}

	@GetMapping("/forum")
	public List<Forum> findAll() {
		System.out.println("文章列表查詢成功");
		return forumService.findAll();
	}

//	@PostMapping("/article_cat/{articleId}")
//	@ResponseBody
//	public Forum findArticleById(@RequestBody Forum forum, @PathVariable int articleId) {
//		System.out.println("執行 findByArticleId 方法成功");
//		return (Forum) forumService.findByArticleId(forum.getArticleId());
//	}

//	@PostMapping("article_cat/{articleId}")
//	@ResponseBody
//	public List<Forum> getArticleId(@PathVariable int articleId, @RequestBody Forum forum) {
//		List<Forum> findArticleId = forumService.findByArticleId(articleId);
//		System.out.println("查看是否獲取Id");
//		return findArticleId;
//	}
	@PostMapping("article_cat/{articleId}")
	public Forum findByArticleId(@PathVariable Integer articleId) {
		Forum findArticleId = forumService.findByArticleId(articleId);

		System.out.println("查看是否獲取Id" + articleId);
		return findArticleId;
	}

	@PutMapping("edit_article/{articleId}")
	public ResponseEntity<String> updateArticleContent(@PathVariable Integer articleId,
			@RequestBody String articleContent) {
		System.out.println(articleContent);
		articleContent = articleContent.replace("\"", "");
		System.out.println(articleContent);
		Forum updatedForum = forumService.updateArticleContent(articleContent, articleId);
		if (updatedForum != null) {
			return ResponseEntity.ok("文章內容已更新");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	http://localhost:8080/petpet/user/member_center_article.html  ?
	@DeleteMapping("delete/{articleId}")
	public ResponseEntity<String> deleteArticle(@PathVariable Integer articleId) {
		forumService.deleteArticleByArticleId(articleId);
		return ResponseEntity.ok("刪除文章成功");
	}

//	@GetMapping("/article_cat/{articleId}")
//	public ResponseEntity<Forum> getForumById(@PathVariable int articleId) {
//		Forum forum = forumService.findByArticleId(articleId);
//		if (forum == null) {
//			return ResponseEntity.notFound().build();
//		}
//		System.out.println("getmapping:??? ok?");
//		return ResponseEntity.ok(forum);
//	}

//	@GetMapping("/article_cat/{articleId}")
//	public Forum findByArticleId(@PathVariable("articleId") int articleId, @RequestBody Forum forum) {
//		System.out.println("controller層：findByArticleId有被呼叫到");
//		return forumService.findByArticleId(articleId);
//	}

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
