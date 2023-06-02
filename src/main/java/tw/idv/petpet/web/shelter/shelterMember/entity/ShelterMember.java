package tw.idv.petpet.web.shelter.shelterMember.entity;

import java.sql.Blob;
import java.sql.Timestamp;

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
import tw.idv.petpet.core.pojo.Core;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shelter_member")
public class ShelterMember extends Core{
	private static final long serialVersionUID = -4258996471247362737L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer shelterId;
	@Column
	private String shelterName;
	@Column
	private String shelterPrincipal;
	@Column
	private String shelterAddress;
	@Column
	private String shelterPhone;
	@Column
	private String shelterEmail;
	@Column
	private String shelterPassword;
}
