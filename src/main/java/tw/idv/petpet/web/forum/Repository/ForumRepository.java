package tw.idv.petpet.web.forum.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer>{
	
//	// 創建文章並儲存在資料庫
//	Forum save2(Forum forum);
//	
//	// 刪除文章
//	void delet2(Forum forum);
}
