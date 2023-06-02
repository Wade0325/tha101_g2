package tw.idv.petpet.web.admin.dto;

import lombok.Data;

@Data
public class AdminUpdateVO {
	private Integer adminId;
	private String adminName;
	private String adminPassword;
}
