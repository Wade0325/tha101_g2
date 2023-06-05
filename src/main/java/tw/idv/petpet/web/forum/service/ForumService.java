package tw.idv.petpet.web.forum.service;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumService extends CoreService{

	Forum createForum(Forum forum);
	
	void deleteForum(int articleId);
}
