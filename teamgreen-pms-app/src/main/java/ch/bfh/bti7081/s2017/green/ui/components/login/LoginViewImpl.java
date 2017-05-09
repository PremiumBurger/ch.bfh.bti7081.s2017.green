package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

/**
 * Created by joris on 08.05.17.
 */
public class LoginViewImpl extends MasterPageImpl implements LoginView {

    private LoginViewListener listener;

    public LoginViewImpl() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setResponsive(true);

        Label username = new Label("Username");
        TextField usernameField = new TextField();
        layout.addComponents(username, usernameField);

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();

        layout.addComponents(passwordLabel, passwordField);

        Button loginButton = new Button("Login");
        loginButton.setIcon(VaadinIcons.SIGN_IN);
        loginButton.addClickListener(b -> listener.onButtonClick());
        layout.addComponent(loginButton);

        setViewContent(layout);
    }

    @Override
    public void addListener(LoginViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void doSomething(HealthVisitorBean firstVisitor) {
        setViewContent(new Label(firstVisitor.toString()));
    }
}
