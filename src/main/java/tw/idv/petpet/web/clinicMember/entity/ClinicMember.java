package tw.idv.petpet.web.clinicMember.entity;

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
public class ClinicMember extends Core {
	private static final long serialVersionUID = -4258996471247362737L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer clinicId;
	@Column
	private String clinicName;
	@Column
	private String clinicPrincipal;
	@Column
	private String clinicEmail;
	@Column
	private String clinicPassword;
	@Column
	private String clinicPhone;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column
	private Timestamp clinicMemberCreateDate;
	@Column
	private String clinicAddress;
	@Column
	private byte[] clinicPhoto1;
	@Column
	private byte[] clinicPhoto2;
	@Column
	private byte[] clinicPhoto3;
	@Column
	private String clinicService;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column
	private Timestamp clinicMemberLastUpdateDate;
	
	public void setDate(Timestamp clinicMemberLastUpdateDate) {
		this.clinicMemberLastUpdateDate = clinicMemberLastUpdateDate;
		
		//建立時間為空則最後更新時間為建立時間
		if (this.clinicMemberCreateDate == null) {
			this.clinicMemberCreateDate = clinicMemberLastUpdateDate;
		}
	}

	public Timestamp getdate(Timestamp clinicMemberLastUpdateDate) {
		return clinicMemberLastUpdateDate;
	}

}
