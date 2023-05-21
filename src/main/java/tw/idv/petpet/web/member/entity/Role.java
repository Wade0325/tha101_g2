package tw.idv.petpet.web.member.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Role extends Core {
	private static final long serialVersionUID = 2791328122275752602L;
	@Id
	private Integer id;
	private String name;
}
