package tw.idv.petpet.web.shop.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

public class productData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer proId; //id
	@Column
	private String proName;
	@Column
	private Integer proPrice;
	@Column(insertable = false)
	private Integer sold;
	@Column
	private Integer proAmount; //商品庫存數量
	@Column
	private String proDet; //商品描述
	@Column
	private byte[] proPic1;
	@Column
	private byte[] proPic2;
	@Column
	private byte[] proPic3;
	@Column(insertable = false)  
	private Timestamp createTime;   //上架時間
	@Column(insertable = false)
	private Timestamp proLastModifiedTime; //最後更新時間
	@Column(insertable = false)
	private String proStatus; //上架狀態
	@Column
	private String cateName; //商品類別
	@Column 
	private String companyId; //廠商會員帳號
	@Column
	private String email;

}
