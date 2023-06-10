package tw.idv.petpet.web.shelter.adoptApply.entity;

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
import tw.idv.petpet.core.pojo.Core;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdoptApply extends Core{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer applyId;
    private Integer userId;
    private Integer animalId;
	private String adopterId;
	private String adopterName;
	private String adopterEmail;
	private Date adopterBirth;
	private String adopterPhone;
	private String adopterContactTime;
	private String adopterAddress;
    private String homeType;
    private String homeSize;
    private String plan;
    private String question;
    private Date adopterApplyDate;
    @Column(insertable = false)
    private String adopterChecked;
    private String userAccount;
}
