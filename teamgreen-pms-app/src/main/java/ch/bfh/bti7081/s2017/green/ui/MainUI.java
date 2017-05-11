package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.address.AddressView;
import ch.bfh.bti7081.s2017.green.ui.components.address.AddressViewImpl;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class MainUI extends UI {

    @Autowired
    private LoginView loginView;

    @Autowired
    private AddressView addressView;

    @Override
    protected void init(VaadinRequest request) {
        // TODO: find a solution for this cast...
        setContent((AddressViewImpl) addressView);
    }
}
