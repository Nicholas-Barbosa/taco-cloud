package tacos.dto;

import tacos.domain.User;

public class UserDTO {

	private String username;
	private String fullname;
	private String street;
	private String city;

	private UserDTO(User user) {
		super();
		this.username = user.getUsername();
		this.fullname = user.getFullname();
		this.street = user.getStreet();
		this.city = user.getCity();
	}
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public static UserDTO toDTO(User user) {
		return new UserDTO(user);
	}

	
	public UserDTO(String username, String fullname, String street, String city) {
		super();
		this.username = username;
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
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", fullname=" + fullname + ", street=" + street + ", city=" + city
				+ "]";
	}

	
}
