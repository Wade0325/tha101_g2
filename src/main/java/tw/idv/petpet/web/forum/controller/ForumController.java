package tw.idv.petpet.web.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.forum.Repository.ForumRepository;
import tw.idv.petpet.web.forum.entity.Forum;

@RestController
public class ForumController {

	@Autowired
	private ForumRepository forumRepository;
	
	@PostMapping("/publish")
	public String insert(@RequestBody Forum forum) {
		forumRepository.save(forum);
		return "執行資料庫的 create 操作";
	}
}
