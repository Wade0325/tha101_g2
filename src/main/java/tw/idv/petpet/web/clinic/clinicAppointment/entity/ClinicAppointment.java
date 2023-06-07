package tw.idv.petpet.web.clinic.clinicAppointment.entity;

import java.time.LocalDate;

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
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicAppointment extends Core {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer reservationNumber;
	@Column
	private Integer clinicId;
	@Column
	private String clinicName;
	@Column
	private String vetName;
	@Column
	private LocalDate appointDate;
	@Column
	private String appointTime;
	@Column
	private String ownerMobile;
	@Column
	private String petType;
	@Column
	private String petName;
	@Column
	private String serviceItem;
	@Column
	private String ownerName;
	@Column
	private String petSituation;
}
