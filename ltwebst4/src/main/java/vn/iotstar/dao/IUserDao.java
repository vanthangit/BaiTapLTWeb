package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);
	
	UserModel get(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
}
