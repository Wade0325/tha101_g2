package tw.idv.petpet.web.user.service;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.user.entity.User;

public interface UserService extends CoreService {
	
	User register(User user);


}
