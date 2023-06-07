package tw.idv.petpet.web.admin.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "report_article")
@Data
public class ReportArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;
	
	private Integer userId;
	private Integer articleId;
	private Integer replyId;
	private Integer adminId;
	private Timestamp reportTime;
	private String reportReason;
	private String confirmCode;
}
