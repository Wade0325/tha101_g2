package tw.idv.petpet.web.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.petpet.web.user.entity.User;

@Entity
@Table(name = "article_comment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reply_time")
    private Date replyTime;

    @Column(name = "reply_update_time")
    private Date replyUpdateTime;

    @Column(name = "reply_status")
    private Integer replyStatus;
}
