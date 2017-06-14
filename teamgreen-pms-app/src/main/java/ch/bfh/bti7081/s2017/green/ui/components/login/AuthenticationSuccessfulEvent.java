package ch.bfh.bti7081.s2017.green.ui.components.login;

import com.github.scribejava.core.model.Token;
import green.auth.OAuthService;
import green.event.Event;

/**
 * Created by Lukas on 14.06.2017.
 */
public class AuthenticationSuccessfulEvent extends Event {
    private Token token;
    private boolean isOAuth2;
    private OAuthService.Service service;
    private String key;
    private String secret;

    public AuthenticationSuccessfulEvent (Token token, boolean isOAuth2, OAuthService.Service service, String key, String secret) {
        this.token = token;
        this.isOAuth2 = isOAuth2;
        this.service = service;
        this.key = key;
        this.secret = secret;
    }

    public Token getToken () {
        return token;
    }

    public boolean isOAuth2 () {
        return isOAuth2;
    }

    public OAuthService.Service getService () {
        return service;
    }

    public String getKey () {
        return key;
    }

    public String getSecret () {
        return secret;
    }
}
