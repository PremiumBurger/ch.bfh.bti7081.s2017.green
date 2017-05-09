package ch.bfh.bti7081.s2017.green.ui.presenter;

import ch.bfh.bti7081.s2017.green.ui.model.Login;
import ch.bfh.bti7081.s2017.green.ui.view.component.login.LoginView;
import ch.bfh.bti7081.s2017.green.ui.view.component.login.LoginViewListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joris on 08.05.17.
 */
public class LoginViewPresenter implements LoginViewListener {
    private LoginView loginView;
    private Login login;

    @Autowired
    public LoginViewPresenter(LoginView loginView, Login login) {
        this.loginView = loginView;
        this.login = login;
        loginView.addListener(this);
    }

    public void login() {
        System.out.println("Login");
    }
}
