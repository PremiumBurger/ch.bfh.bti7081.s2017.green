package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class LoginViewImpl extends MasterPageImpl implements LoginView {

    private LoginViewListener listener;

    private Label userNameLabel;
    private TextField userName;
    private Label passwordLabel;
    private TextField password;
    private Button loginButton;

    public LoginViewImpl() {
        VerticalLayout layout = new VerticalLayout();

        userNameLabel = new Label("User Name");
        userName = new TextField();
        passwordLabel = new Label("Password");
        password = new TextField();
        loginButton = new Button("Login");
        loginButton.setIcon(VaadinIcons.SIGN_IN);
        loginButton.addClickListener(b -> listener.onLoginClick());

        layout.addComponents(userNameLabel, userName, passwordLabel, password, loginButton);
        setViewContent(layout);
    }

    @Override
    public void addListener(LoginViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void login() {
        System.out.println("Login Test");
    }
}
