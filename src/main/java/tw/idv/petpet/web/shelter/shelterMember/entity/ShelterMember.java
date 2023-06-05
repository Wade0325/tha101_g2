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

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShelterMember {
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
