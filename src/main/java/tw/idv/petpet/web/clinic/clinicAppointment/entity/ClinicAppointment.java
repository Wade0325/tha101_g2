package tw.idv.petpet.web.clinic.clinicAppointment.entity;

import java.sql.Date;
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
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column
	private Date appointDate;
	@Column
	private Integer appointTime;
	@Column
	private String ownerMobile;
	@Column
	private String petType;
	@Column
	private String petName;
	@Column
	private Integer serviceItem;
	@Column
	private String ownerName ;
	@Column
	private String petSituation;
}
