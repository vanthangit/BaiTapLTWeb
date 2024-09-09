package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	 
	UserModel get(String username);
	
	
	void insert(UserModel user);
	
	boolean register(String username, String password, String email, String fullname, String images);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
}
