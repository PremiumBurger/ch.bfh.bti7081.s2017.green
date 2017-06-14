package green.auth;

public class UserProfile {
	
	private final OAuthService.Service service;
	private final UserToken token;
	private final String identifier;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String imgUrl;
	
	public UserProfile(OAuthService.Service service, UserToken token, String identifier, String firstName, String lastName, String email, String imgUrl) {
		this.service = service;
		this.token = token;
		this.identifier = identifier;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imgUrl = imgUrl;
	}

	public OAuthService.Service getService() {
		return service;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public UserToken getToken() {
		return token;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
