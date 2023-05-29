package tw.idv.petpet.web.shop.entity;

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
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer detailId;
	@Column
	private String orderNumber;
	@Column
	private Integer productId;
	@Column
	private String totalAmount;
	@Column
	private Integer producQuantity;
	@Column
	private Integer totalQuantity;
	
	
}
