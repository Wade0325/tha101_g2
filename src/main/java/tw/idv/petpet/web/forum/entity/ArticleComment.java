package tw.idv.petpet.web.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "article_comment")
public class ArticleComment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_reply_id")
    private int articleReplyId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "reply_content", length = 200)
    private String replyContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reply_time")
    private Date replyTime;

    @Column(name = "reply_update_time")
    private Date replyUpdateTime;

    @Column(name = "reply_status")
    private Integer replyStatus;
}
