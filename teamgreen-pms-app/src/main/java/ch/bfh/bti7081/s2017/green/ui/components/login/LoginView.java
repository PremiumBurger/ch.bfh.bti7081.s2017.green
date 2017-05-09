package ch.bfh.bti7081.s2017.green.ui.components.login;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;

/**
 * Created by joris on 08.05.17.
 */
public interface LoginView {
    void addListener(LoginViewListener listener);

    void doSomething(HealthVisitorBean firstVisitor);
}
