package ch.bfh.bti7081.s2017.green.ui.components.login;

import com.github.scribejava.core.model.Token;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import green.auth.OAuthService;
import green.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.oauthpopup.OAuthListener;
import org.vaadin.addon.oauthpopup.OAuthPopupButton;
import org.vaadin.addon.oauthpopup.buttons.FacebookButton;
import org.vaadin.addon.oauthpopup.buttons.GitHubButton;

@org.springframework.stereotype.Component
public class LoginViewImpl extends VerticalLayout implements LoginView {
    private EventBus eventBus;

    @Autowired
    public LoginViewImpl (EventBus eventBus) {
        this.eventBus = eventBus;
        setSizeFull();
        setMargin(false);
        setSpacing(false);
    }

    private Component buildLoginForm () {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setMargin(false);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Remember me", true));
        return loginPanel;
    }

    private Component buildFields () {
        HorizontalLayout fields = new HorizontalLayout();
        fields.addStyleName("fields");

        OAuthPopupButton fbButton = createFacebookButton();
        if (fbButton != null) {
            fields.addComponent(fbButton);
            fields.setComponentAlignment(fbButton, Alignment.BOTTOM_LEFT);
        }

        OAuthPopupButton githubButton = createGithubButton();
        if (githubButton != null) {
            fields.addComponent(githubButton);
            fields.setComponentAlignment(fbButton, Alignment.BOTTOM_LEFT);
        }
        return fields;
    }

    private OAuthPopupButton createGithubButton () {
        String key = "48bfec40a5c7b78b46ef";
        String secret = "2dcb7ad8cdbcafef1615357c0eb6a176eeb28f5c";
        if (key == null || secret == null) {
            return null;
        }
        GitHubButton button = new GitHubButton(key, secret);
        button.setCaption("Login with Github");
        return initButton(button, OAuthService.Service.GITHUB, key, secret);
    }

    private OAuthPopupButton createFacebookButton () {
        String key = "1830725237245643";
        String secret = "7292241f5b8cdb2d84024dd6b19d7158";
        if (key == null || secret == null) {
            return null;
        }
        FacebookButton button = new FacebookButton(key, secret);
        button.setCaption("Login with Facebook");
        return initButton(button, OAuthService.Service.FACEBOOK, key, secret);
    }

    private OAuthPopupButton initButton (OAuthPopupButton button, final OAuthService.Service service, final String key, final String secret) {
        button.addOAuthListener(new OAuthListener() {
            @Override
            public void authSuccessful (Token token, boolean isOAuth2) {
                eventBus.fireEvent(new AuthenticationSuccessfulEvent(token, isOAuth2, service, key, secret));
            }

            @Override
            public void authDenied (String var1) {
                Notification.show("Not authenticated.");
            }
        });
        return button;
    }

    private Component buildLabels () {
        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("BOOBS Dashboard");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }

    public void onAfterBeanInitializaiton () {
        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter (ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
