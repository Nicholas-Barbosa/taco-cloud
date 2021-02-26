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

	public static UserDTO toDTO(User user) {
		return new UserDTO(user);
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

}
