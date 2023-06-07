package tw.idv.petpet.web.admin.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity(name = "report_user")
@Data
public class ReportUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userSn;

	private String companyId;
	private String userId;
	private String userContent;
	@JsonFormat(pattern = "yyyy/MM/dd")
//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column(insertable = false)
	private Timestamp userDate;
	@Column(insertable = false)
	private String confirmCode;
}
