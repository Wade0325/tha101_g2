package tw.idv.petpet.web.shop.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import tw.idv.petpet.web.member.entity.Role;


@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer pro_id; //id
	@Column
	private String pro_name;
	@Column
	private Integer pro_price;
	@Column(insertable = false)
	private Integer sold;
	@Column
	private Integer pro_amount; //商品庫存數量
	@Column
	private String pro_det; //商品描述
	@Column
	private byte[] pro_pic1;
	@Column
	private byte[] pro_pic2;
	@Column
<<<<<<< HEAD
	private byte[] pro_pic3;
	@Column(insertable = false)  
//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
=======
	private String pro_pic3;
	
	
//	@Column(insertable = false)  
//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Column
>>>>>>> main
	private Timestamp create_time;   //上架時間
	@Column(insertable = false)
	private Timestamp pro_lastmodified_time; //最後更新時間
	@Column(insertable = false)
	private String pro_status; //上架狀態
	@Column
	private String cate_name; //商品類別
	@Column 
	private String company_id; //廠商會員帳號
	@Column 
	private String email;
}
