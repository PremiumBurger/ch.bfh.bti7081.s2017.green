package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.vaadin.ui.Notification;
import green.auth.OAuthService;
import green.auth.UserProfile;
import green.auth.UserToken;
import green.event.EventBus;
import green.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginViewPresenter {
    private LoginView loginView;
    private Login login;
    private EventBus eventBus;

    @Autowired
    public LoginViewPresenter(LoginView loginView, Login login, EventBus eventBus) {
        this.loginView = loginView;
        this.login = login;
        this.eventBus = eventBus;
        this.eventBus.addHandler(this);
    }

    @EventHandler
    public void onAuthSuccess(AuthenticationSuccessfulEvent event) {
        OAuth2AccessToken oauthToken = (OAuth2AccessToken) event.getToken();
        UserToken userToken = new UserToken(oauthToken.getAccessToken());
        OAuthService serv = OAuthService.createService(event.getService(), event.getKey(), event.getSecret(), userToken);
        UserProfile profile = serv.getUserProfile();
        if (profile != null) {
            eventBus.fireEvent(new UserLoginRequestedEvent(profile));
        } else {
            Notification.show("Not authenticated.");
        }
    }
}
