package tacos.dto;

public class UserForm {

	private String username;

	public String getUsername() {
		return username;
	}
	public UserForm() {
		// TODO Auto-generated constructor stub
	}
	
	

	public UserForm(String username) {
		super();
		this.username = username;
	}
	public void setUsername(String username) {
		System.out.println("Set username");
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserForm [username=" + username + "]";
	}
	
	
}
