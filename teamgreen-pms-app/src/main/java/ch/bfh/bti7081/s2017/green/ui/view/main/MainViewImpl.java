package ch.bfh.bti7081.s2017.green.ui.view.main;

import ch.bfh.bti7081.s2017.green.ui.view.component.login.LoginViewImpl;
import ch.bfh.bti7081.s2017.green.ui.view.component.search.SearchViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
@SpringUI
@Theme("valo")
public class MainViewImpl extends VerticalLayout implements MainView{
    private List<MainViewListener> listeners;


    public MainViewImpl() {

        this.listeners = new ArrayList<>();
        final SearchViewImpl search = new SearchViewImpl();
        final VerticalLayout content = new VerticalLayout();
        final Panel contentPanel = new Panel(content);
        contentPanel.setSizeFull();
        content.addComponent(new LoginViewImpl());

        final VerticalLayout footer = new VerticalLayout(new Label("Footer"));
        final MenuViewImpl menu = new MenuViewImpl();
        addComponents(search,contentPanel,menu);

        setSizeFull();
        setExpandRatio(contentPanel,1);
        setResponsive(true);

    }


    @Override
    public void addListener(MainViewListener viewListener) {
        listeners.add(viewListener);
    }


}
