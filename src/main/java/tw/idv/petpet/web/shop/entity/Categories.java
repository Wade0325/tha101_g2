package tw.idv.petpet.web.product.entity;

import java.sql.Timestamp;

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
public class Categories {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Integer type_id; //id
		@Column
		private String cate_name;
		
}
