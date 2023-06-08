package tw.idv.petpet.web.user.service;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.user.entity.User;

public interface UserService extends CoreService {

	public User register(User user);

	public User getUser(User user);
	
	public User getUser(String userAccount);

	public User login(User user);

	public User update(User user);

	public User update(String account, String password);

	public User updatePwd(User user,User userSession);

}
