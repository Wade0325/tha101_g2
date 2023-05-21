package tw.idv.petpet.web.user.dao;

import tw.idv.petpet.core.dao.CoreDao;
import tw.idv.petpet.web.user.entity.User;

public interface UserDao extends CoreDao<User, Integer>{
	User selectByAccount(String useraccount);

	User selectForLogin(String useraccount, String userpassword);
}
