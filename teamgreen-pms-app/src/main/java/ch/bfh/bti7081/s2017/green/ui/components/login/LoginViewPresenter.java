package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.ui.MainUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginViewPresenter implements LoginViewListener {

    private LoginView loginView;
    private Login login;

    @Autowired
    public LoginViewPresenter(LoginView loginView, Login login) {
        this.loginView = loginView;
        this.login = login;
        loginView.addListener(this);
    }

    @Override
    public void onLoginClick() {
        loginView.login();
        MainUI.navigator.navigateTo("addressView");
    }
}
