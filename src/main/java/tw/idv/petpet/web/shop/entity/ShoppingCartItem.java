package tw.idv.petpet.web.shop.entity;

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
public class ShoppingCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer cart_item_id; //id
	@Column
	private Integer cart_id;
	@Column
	private Integer pro_id;
	@Column
	private String pro_name;
	@Column
	private Integer pro_price; 
	@Column
	private Integer pro_amount; 
	@Column
	private Timestamp create_time; 
	@Column
	private String pro_pic1; 
}
