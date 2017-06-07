package green.auth;

public class UserProfile {
	
	private final OAuthService.Service service;
	private final UserToken token;
	private final String identifier;
	private final String name;
	private final String email;
	private final String imgUrl;
	
	public UserProfile(OAuthService.Service service, UserToken token, String identifier, String name, String email, String imgUrl) {
		this.service = service;
		this.token = token;
		this.identifier = identifier;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
