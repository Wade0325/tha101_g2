package tw.idv.petpet.web.forum.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.forum.entity.Forum;

public interface ForumRepository extends JpaRepository<Forum, Integer>{
	
	//獲取所有文章的方法
//	void updateForum(int articleId, Integer articleGroupId ,
//			String articleTitle, String articleContent);
	 List<Forum> findAll();
	 
	 Forum findByArticleId(Integer articleId);
	 
	 @Modifying
	 @Query(value = "UPDATE forum SET article_content = ?1 WHERE article_id = ?2", nativeQuery = true)
	 Forum updateArticleContent(String articleContent, Integer articleId);
	 
	 
	 void deleteArticleByArticleId(Integer articleId);
	 
	 @Modifying
	 @Query(value = "DELETE ac FROM article_comment ac JOIN forum f ON ac.article_id = f.article_id WHERE f.article_id = ?1", nativeQuery = true)
	 void deleteArticle(Integer articleId);
	 
}
