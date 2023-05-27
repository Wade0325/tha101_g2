package tw.idv.petpet.web.shelter.shelterAnimal.entity;

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
public class ShelterAnimal extends Core{
	/**
	 * 會員資料
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer animalId;
	private Integer userId;
    private String animalName;
    private String animalType;
    private String animalCategory;
    private String animalColor;
    private String animalGender;
    private Date animalDate;
    private String animalAge;
    private byte[] animalPhoto1;
    private byte[] animalPhoto2;
    private byte[] animalPhoto3;
    private String animalDescribe;
    private Integer ifAdopteD;
}
