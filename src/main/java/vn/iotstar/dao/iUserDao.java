package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.dao.*;
import vn.iotstar.models.UserModel;

public interface iUserDao {
	List<UserModel> findAll();
	UserModel findAId(int id);
	void insert(UserModel user);
}