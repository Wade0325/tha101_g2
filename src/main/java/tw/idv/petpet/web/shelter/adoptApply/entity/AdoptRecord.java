package tw.idv.petpet.web.shelter.adoptApply.entity;

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
public class AdoptRecord  extends Core{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private String adopterName;
    private String adopterPhone;
    private String animalName;
    private String animalType;
    private Date adopterApplyDate;
    private String adopterChecked;
	
}
