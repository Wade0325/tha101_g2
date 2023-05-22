package tw.idv.petpet.web.shelter.shelterAnimal.entity;

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
public class ShelterAnimal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer animalId;
	@Column
	private Integer userId;
	@Column
	private String animalName;
	@Column
	private String animalType;
	@Column
	private String animalCategory;
	@Column
	private String animalColor;
	@Column
	private String animalGender;
	@Column
	private Date animalDate;
	@Column
	private Integer animalAge;
	@Column
	private Blob animalPhoto1;
	@Column
	private Blob animalPhoto2;
	@Column
	private Blob animalPhoto3;
	@Column
	private String animalDescribe;
	@Column
	private boolean adopt;
	@Column
	private boolean ifAdopted;
}

