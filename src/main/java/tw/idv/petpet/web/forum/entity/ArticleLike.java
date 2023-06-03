package tw.idv.petpet.web.forum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "article_like")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_like_id")
	private int articleLikeId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "article_id")
	private Integer articleId;

	@Column(name = "article_like_status")
	private Integer articleLikeStatus;
}
