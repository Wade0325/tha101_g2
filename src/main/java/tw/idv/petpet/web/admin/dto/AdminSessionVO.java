package tw.idv.petpet.web.admin.dto;

import lombok.Data;

@Data
public class AdminSessionVO {
	private Integer adminId;
	private String adminName;
	private String adminAccount;
	private String adminPassword;
}
