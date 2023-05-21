package tw.idv.petpet.web.member.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Member extends Core {
	private static final long serialVersionUID = 1062017833925367218L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String nickname;
	@Column(insertable = false)
	private Boolean pass;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(insertable = false)
	private String creator;
	@Column(name = "CREATED_DATE", insertable = false)
	private Timestamp createdDate;
	@Column
	private String updater;
	@Column(name = "LAST_UPDATED_DATE")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp lastUpdatedDate;
	@Column
	private byte[] image;
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private Role role;
}
