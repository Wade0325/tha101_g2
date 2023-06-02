package tw.idv.petpet.web.clinic.businessDate.entity;

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
public class BusinessDate extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer businessSn;
	@Column
	private Integer clinicId;
	@Column
	private Integer vetSn;
	@Column
	private Integer weekDate;
	@Column
	private Integer morningBusiness;
	@Column
	private Integer morningAppointMax;
	@Column
	private Integer afternoonBusiness;
	@Column
	private Integer afternoonAppointMax;
	@Column
	private Integer nightBusiness;
	@Column
	private Integer nightAppointMax;
}
