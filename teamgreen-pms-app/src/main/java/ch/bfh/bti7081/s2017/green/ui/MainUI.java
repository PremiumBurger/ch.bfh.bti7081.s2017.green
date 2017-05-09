package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorServiceImpl;
import ch.bfh.bti7081.s2017.green.ui.components.login.Login;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginViewImpl;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginViewPresenter;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joris on 08.05.17.
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {
    private HealthVisitorService service;

    @Autowired
    public MainUI(HealthVisitorService service) {
        this.service = service;
    }

    @Override
    protected void init(VaadinRequest request) {
        LoginViewImpl loginView = new LoginViewImpl();

        new LoginViewPresenter(loginView, new Login(service));
        setContent(loginView);
    }
}
