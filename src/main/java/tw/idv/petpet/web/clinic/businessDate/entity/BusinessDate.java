package tw.idv.petpet.web.clinic.businessDate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class BusinessDate extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer businessSn;
	@Column
	private String clinicName; 
	@Column
	private Integer vetSn;
	@Column
	@Temporal(TemporalType.DATE)
	private Date weekDate;
	@Column
	private String morningBusiness;
	@Column
	private Integer morningAppointMax;
	@Column
	private String afternoonBusiness;
	@Column
	private Integer afternoonAppointMax;
	@Column
	private String nightBusiness;
	@Column
	private Integer nightAppointMax;
}
