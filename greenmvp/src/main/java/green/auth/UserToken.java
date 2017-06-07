package green.auth;

// Immutable
public class UserToken {
	
	private final String token;
	private final String secret;
	
	public UserToken(String token, String secret) {
		this.token = token;
		this.secret = secret;
	}

	public String getToken() {
		return token;
	}

	public String getSecret() {
		return secret;
	}
	
	

}
