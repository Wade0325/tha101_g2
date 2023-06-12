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
import tw.idv.petpet.web.user.entity.User;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer details_id;
	@Column
	private Integer company_id;
	@Column
	private Integer user_id;
	@Column
	private Integer amount;
	@Column
	private String user_name;
//	@Column
//	private Integer quantity;
//	@Column
//	private Integer totalQuantity;
	
	
}
