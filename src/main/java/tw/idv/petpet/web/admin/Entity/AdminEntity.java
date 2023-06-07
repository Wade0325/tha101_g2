package tw.idv.petpet.web.admin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "admin")
@Data
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	private String adminName;
	private String adminAccount;
	private String adminPassword;
}
