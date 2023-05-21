package tw.idv.petpet.web.member.dao;

import tw.idv.petpet.core.dao.CoreDao;
import tw.idv.petpet.web.member.entity.Member;

public interface MemberDao extends CoreDao<Member, Integer> {
	
	Member selectByUsername(String username);
	
	Member selectForLogin(String username, String password);
}
