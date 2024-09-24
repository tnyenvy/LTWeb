package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.dao.*;
import vn.iotstar.models.User;
import vn.iotstar.models.UserModel;

public interface iUserDao {
	List<UserModel> findAll();

	UserModel findAId(int id);

	void insert(UserModel user);

	UserModel FindByUserName(String username);

	void insert(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	void update(String password, String email);

	List<String> search(String username);

	void updateProfile(String username, String fullname, String phone, String images);
}
