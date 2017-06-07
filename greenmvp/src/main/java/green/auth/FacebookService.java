package green.auth;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;

public class FacebookService extends OAuthService {

	public FacebookService(String apiKey, String apiSecret, UserToken token) {
		super(Service.FACEBOOK, apiKey, apiSecret, token);
	}

	private FacebookClient client;
	
	@Override
	protected void connect() {
		client = new DefaultFacebookClient(getUserToken().getToken());
	}

	@Override
	protected UserProfile fetchUserProfile() {
		com.restfb.types.User me = client.fetchObject("me", com.restfb.types.User.class, Parameter.with("fields", "id,name,email"));
		String id = me.getId();
		String name = me.getName();
		String email = me.getEmail();
		String imgUrl =  "https://graph.facebook.com/" + me.getId() + "/picture";
		return new UserProfile(Service.FACEBOOK, getUserToken(), id, name, email, imgUrl);
	   
	}

}
