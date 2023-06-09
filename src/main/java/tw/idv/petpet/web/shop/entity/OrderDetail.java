package tw.idv.petpet.web.shop.entity;

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

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer orderdetail_id;
	@Column
	private Integer user_id;
	
	@Column
	private Timestamp order_date;
	@Column
	private String order_state;
	@Column
	private String pay_state;
	@Column
	private String ship_state;
	
	@Column(name = "order_amount")
	private Integer orderAmount;
//	@Column
//	private String card_num;
	@Column
	private String addr_name;
	@Column
	private String phone;
	@Column
	private String address;
	
//	@Column
//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
//	private Timestamp orderDetailLastUpdateDate;

}
