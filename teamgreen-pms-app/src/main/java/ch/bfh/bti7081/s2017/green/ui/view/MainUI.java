package ch.bfh.bti7081.s2017.green.ui.view;

import ch.bfh.bti7081.s2017.green.ui.model.Main;
import ch.bfh.bti7081.s2017.green.ui.presenter.LoginViewPresenter;
import ch.bfh.bti7081.s2017.green.ui.presenter.MainViewPresenter;
import ch.bfh.bti7081.s2017.green.ui.view.component.address.AddressViewImpl;
import ch.bfh.bti7081.s2017.green.ui.view.component.login.LoginViewImpl;
import ch.bfh.bti7081.s2017.green.ui.view.main.MainView;
import ch.bfh.bti7081.s2017.green.ui.view.main.MainViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * Created by joris on 08.05.17.
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {
    @Override
    protected void init(VaadinRequest request) {


        setContent(new LoginViewImpl());


    }
}
