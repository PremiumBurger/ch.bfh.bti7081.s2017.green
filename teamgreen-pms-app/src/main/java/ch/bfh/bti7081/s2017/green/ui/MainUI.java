package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.service.AddressService;
import ch.bfh.bti7081.s2017.green.ui.components.address.Address;
import ch.bfh.bti7081.s2017.green.ui.components.address.AddressViewImpl;
import ch.bfh.bti7081.s2017.green.ui.components.address.AddressViewPresenter;
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
    @Autowired
    private AddressService service;

    /*@Autowired
    public MainUI(HealthVisitorService service) {
        this.service = service;
    }*/

    @Override
    protected void init(VaadinRequest request) {
        AddressViewImpl addressView = new AddressViewImpl();

        new AddressViewPresenter(addressView, new Address(service));
        setContent(addressView);

        /*LoginViewImpl loginView = new LoginViewImpl();

        new LoginViewPresenter(loginView, new Login(service));
        setContent(loginView);*/
    }
}
