package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private String password;
	private String avatar;
	private int roleid;
	private String phone;
	private Date createDate;

//Tạo constructor, getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public interface UserService {
		void insert(User user);

		boolean register(String email, String password, String username, String fullname, String phone);

		boolean checkExistEmail(String email);

		boolean checkExistUsername(String username);

		boolean checkExistPhone(String phone);
	}
}