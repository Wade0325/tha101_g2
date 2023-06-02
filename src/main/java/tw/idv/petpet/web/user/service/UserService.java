package tw.idv.petpet.web.user.service;

import tw.idv.petpet.web.user.entity.User;

public interface UserService {

	public User register(User user);

	public User findById(Integer userid);

	public String login(User user);
}
