package tw.idv.petpet.web.shop.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer company_id;
	@Column
	private String company_name;
	@Column
	private String company_email;
	@Column(name = "company_pw")
	private String company_password;
	@Column
	private String company_man;
//	@Column
//	private String companyEmail;
	@Column
	private String company_phone;
	@Column(name = "company_addr")
	private String company_address;
//	@Column
//	private String companyNum;

}
