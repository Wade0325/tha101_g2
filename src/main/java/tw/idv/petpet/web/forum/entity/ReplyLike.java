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
@Table(name = "reply_like")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_like_id")
	private int replyLikeId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "article_reply_id")
	private Integer articleReplyId;

	@Column(name = "article_like_status")
	private Integer articleLikeStatus;
}
