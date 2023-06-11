package tw.idv.petpet.web.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.petpet.core.pojo.Core;

@Entity
@Table(name = "forum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Forum extends Core{   // 這個forum有publish的功能，兼具publish entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private int articleId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "article_group_id")
	private Integer articleGroupId;

	@Column(name = "article_title", length = 20)
	private String articleTitle;

	@Column(name = "article_content", length = 200)
	private String articleContent;

	@Lob
	@Column(name = "article_image")
	private byte[] articleImage;

	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "article_create_time")
	private Date articleCreateTime;

	
	@Column(name = "modifier_time")
	private Date modifierTime;

	@Column(name = "article_status")
	private Integer articleStatus;
}
