package tw.idv.petpet.web.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "report_article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "article_id")
	private Integer articleId;

	@Column(name = "reply_id")
	private Integer replyId;

	@Column(name = "admin_id")
	private int adminId;

	
	@Column(name = "report_time")
	private Date reportTime;

	@Column(name = "report_reason", length = 200)
	private String reportReason;

	@Column(name = "confirm_code", length = 20)
	private String confirmCode;

}
