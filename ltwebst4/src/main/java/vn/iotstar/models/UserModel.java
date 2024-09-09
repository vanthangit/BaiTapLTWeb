package vn.iotstar.models;

import java.io.Serializable;

public class UserModel implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String images;
	
	
	
	public UserModel() {
		super();
	}

	
	public UserModel(String username, String password, String email, String fullname, String images) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.images = images;
	}
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "UserModel [username=" + username + ", password=" + password + ", email=" + email
				+ ", fullname=" + fullname + ", images=" + images + "]";
	}

}
