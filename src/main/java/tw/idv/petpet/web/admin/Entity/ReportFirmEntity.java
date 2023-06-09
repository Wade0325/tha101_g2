package tw.idv.petpet.web.admin.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "report_firm")
@Data
public class ReportFirmEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer firmSn;
	
	private String userId;
	private String companyId;
	private String firmContent;
	@Column(insertable = false)
	private Timestamp firmDate;
	@Column(insertable = false)
	private String confirmCode;
}