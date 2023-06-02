package tw.idv.petpet.web.forum.Repository;


import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumRepository extends CrudRepository<Forum, Integer>{
	
}
