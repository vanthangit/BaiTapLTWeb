package vn.iotstar.services.impl;

import vn.iotstar.config.DBConnectMySQL;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.dao.IUserDao;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = userDao.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String images) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			userDao.insert(new UserModel(username, password, email, fullname, images));
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
	
	public static void main(String[] args) {
	UserServiceImpl userService = new UserServiceImpl();

	// Thử đăng ký người dùng
	boolean registered = userService.register("vanthang", "1234","thang@gmail.com", "Nguyen Van Thang", null);
	if (registered) {
		System.out.println("Đăng ký thành công!");
	} else {
		System.out.println("Đăng ký thất bại hoặc tên người dùng/email đã tồn tại.");
	}

	// Thử đăng nhập
	UserModel user = userService.login("vanthang", "1234");
	if (user != null) {
		System.out.println("Đăng nhập thành công! Người dùng: " + user);
	} else {
		System.out.println("Đăng nhập thất bại.");
	}

	}
}
