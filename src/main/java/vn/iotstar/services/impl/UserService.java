package vn.iotstar.services.impl;

import java.sql.Date;
import java.util.List;

import vn.iotstar.dao.iUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.User;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {

	iUserDao userDao = new UserDaoImpl();

	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {

		return userDao.FindByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user); 
		
	}

	@Override
	public boolean register(String username, String password, String fullname, String email, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis(); java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel(username, password, null, fullname, email, phone, 1, date));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	
	public static void main(String[] args) {
		IUserService userService = new UserService();
		System.out.println(userService.register("Anh", "123", "Nguyễn Trung Anh", "nta2024@gmail.com",null));
	
	}

	@Override
	public void update(String password, String email) {
		userDao.update(password, email);
		
	}
	@Override
	public List<String> search(String username) {
		return userDao.search(username);
	}
	@Override
	public void updateProfile(String username, String fullname, String phone, String images) {
		userDao.updateProfile(username, fullname, phone, images);
	}
	
}