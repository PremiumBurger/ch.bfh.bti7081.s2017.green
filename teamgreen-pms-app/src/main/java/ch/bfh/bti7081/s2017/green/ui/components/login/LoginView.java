package ch.bfh.bti7081.s2017.green.ui.components.login;

public interface LoginView {
    void addListener(LoginViewListener listener);

    void login();
}
