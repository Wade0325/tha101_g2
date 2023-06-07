package dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReportFirmEditVO {
	private Integer firmSn;

	private String userId;
	private String companyId;
	private String firmContent;
	private Timestamp firmDate;
	private String confirmCode;
}
