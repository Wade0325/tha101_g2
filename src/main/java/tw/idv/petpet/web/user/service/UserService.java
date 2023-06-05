package tw.idv.petpet.web.user.service;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.user.entity.User;

public interface UserService extends CoreService {
	
	public User register(User user);

    public User login(User user);

    public User update(User user);
}
