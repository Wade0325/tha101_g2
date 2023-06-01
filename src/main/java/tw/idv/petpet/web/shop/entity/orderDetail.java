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
public class orderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer orderNumber;
	@Column
	private Integer userId;
	
	@Column(insertable = false)
	private Timestamp orderDateTime;
	@Column
	private String ordreState;
	@Column
	private String shipState;
	@Column
	private Integer orderAmount;
	@Column
	private String cardNumber;
	@Column
	private String addrName;
	@Column
	private String userPhone;
	@Column
	private String address;
	@Column
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp orderDetailLastUpdateDate;

}
