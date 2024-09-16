package vn.iotstar.services;

import vn.iotstar.models.User;
import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);

	UserModel FindByUserName(String username);

	void insert(UserModel user);

	boolean register(String username, String password, String fullname, String email, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
