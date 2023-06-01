package tw.idv.petpet.web.clinic.petCases.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.petpet.core.pojo.Core;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetCases extends Core {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer casesSn;
	@Column
	private Integer vetSn;
	@Column
	private Integer userId;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column
	private Timestamp appointDate;
	@Column
	private String ownerMobile;
	@Column
	private String petType;
	@Column
	private String petName;
	@Column
	private Integer petGender;
	@Column
	private Integer petAge;
	@Column
	private String petSituation;
	@Column
	private String treatment;
	@Column
	private Integer result;
}
