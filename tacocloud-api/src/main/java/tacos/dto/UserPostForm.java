package tacos.dto;

import tacos.domain.User;

public class UserPostForm {

	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;

	public UserPostForm() {
		// TODO Auto-generated constructor stub
	}

	public UserPostForm(String username, String password, String fullname, String street, String city) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.street = street;
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public String getFullname() {
		return fullname;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getPassword() {
		return password;
	}

	public User toUser() {
		return new User(username, password, fullname, street, city, null, null, null);
	}
}
