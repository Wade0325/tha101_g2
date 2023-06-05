package tw.idv.petpet.web.forum.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer>{
	
	//獲取所有文章的方法
	List<Forum> findAll();
}
