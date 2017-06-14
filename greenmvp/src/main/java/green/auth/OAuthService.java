package green.auth;

public abstract class OAuthService {
	
	public enum Service {
		GITHUB,
		FACEBOOK
	}

	private final Service service;
	private final String apiKey;
	private final String apiSecret;
	private final UserToken token;
	
	private boolean connected = false;
	
	public static OAuthService createService(Service service, String apiKey, String apiSecret, UserToken token) {
		if (service== Service.FACEBOOK) {
			return new FacebookService(apiKey, apiSecret, token);
		}
		if (service== Service.GITHUB) {
			return new GitHubService(apiKey, apiSecret, token);
		}
		return null;
	}
	
	protected OAuthService(Service service, String apiKey, String apiSecret, UserToken token) {
		this.service = service;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.token = token;
	}
	
	public Service getService() {
		return service;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}
	
	public UserToken getUserToken() {
		return token;
	}

	abstract protected void connect();

	abstract protected UserProfile fetchUserProfile();
	
	
	public UserProfile getUserProfile() {
		ensureConnection();
		return fetchUserProfile();
	}

	private void ensureConnection() {
		if (!connected) {
			connect();
		}
	}


}
