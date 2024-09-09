package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";

		List<UserModel> list = new ArrayList<>(); // Tao 1 list de truyen du lieu

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next())/* Next tung dong toi cuoi bang */ {
				list.add(new UserModel(rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("images")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO users(username, password, email, fullname, images) VALUES(?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username); // Đặt giá trị username vào câu truy vấn
			rs = ps.executeQuery();

			while (rs.next()) { // Nếu tìm thấy user tương ứng
				UserModel user = new UserModel();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM users WHERE username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

}
