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

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdoptApply {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer applyId;
	@Column
    private Integer userId;
	@Column
	private Integer adopterId;
	@Column
	private String adopterName;
	@Column
	private String adopterEmail;
	@Column
	private Date adopterBirth;
	@Column
	private String adopterPhone;
	@Column
	private String adopterContactTime;
	@Column
	private String adopterAddress;
    @Column
    private String homeType;
    @Column
    private Integer homeSize;
    @Column
    private String plan;
    @Column
    private String question;
    @Column
    private Blob lifePicture1;
    @Column
    private Blob lifePicture2;
    @Column
    private Blob lifePicture3;
    @Column
    private Date adopterApplyDate;
    @Column
    private boolean adopterChecked;
}
