package tacos.representationmodel;

import org.springframework.hateoas.RepresentationModel;

import tacos.domain.User;

public class UserRepresentationModel extends RepresentationModel<UserRepresentationModel> {

	private String username;
	private String fullname;
	private String street;
	private String city;

	public UserRepresentationModel(User user) {
		super();
		this.username = user.getUsername();
		this.fullname = user.getFullname();
		this.street = user.getStreet();
		this.city = user.getCity();
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
