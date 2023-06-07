//package tw.idv.petpet.web.forum.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import tw.idv.petpet.web.forum.entity.ArticleLike;
//import tw.idv.petpet.web.forum.service.ArticleLikeService;
//
//@RestController
//public class ArticleLikeController {
//
//	private final ArticleLikeService articleLikeService;
//
//	@Autowired
//	public ArticleLikeController(ArticleLikeService articleLikeService) {
//		this.articleLikeService = articleLikeService;
//	}
//
//	@PostMapping("/create")
//	public ArticleLike createArticleLike(@RequestBody ArticleLike articleLike) {
//		return articleLikeService.createArticleLike(articleLike);
//	}
//
//	@GetMapping("/{articleLikeId}")
//	public ArticleLike getArticleLikeById(@PathVariable int articleLikeId) {
//		return articleLikeService.getArticleLikeById(articleLikeId);
//	}
//
//	@GetMapping("/all")
//	public List<ArticleLike> getAllArticleLikes() {
//		return articleLikeService.getAllArticleLikes();
//	}
//}
