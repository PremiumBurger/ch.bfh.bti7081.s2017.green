package ch.bfh.bti7081.s2017.green.ui.view.component.login;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 08.05.17.
 */
public class LoginViewImpl extends VerticalLayout implements LoginView, LoginViewListener {
    private List<LoginViewListener> listeners;

    public LoginViewImpl() {
        this.listeners = new ArrayList<>();
        HorizontalLayout user = new HorizontalLayout();
        Label username = new Label("Username");
        TextField usernameField = new TextField();
        user.addComponents(username,usernameField);

        HorizontalLayout password = new HorizontalLayout();
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();

        user.addComponents(passwordLabel,passwordField);

        Button loginButton = new Button("Login");
        loginButton.setIcon(VaadinIcons.SIGN_IN);
        setResponsive(true);
        addComponents(user,password,loginButton);
    }

    @Override
    public void addListener(LoginViewListener viewListener) {
        listeners.add(viewListener);
    }
}
