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
public abstract class MainViewImpl extends VerticalLayout implements MainView {
    private List<MainViewListener> listeners;
    private Component header;

    private Panel contentPanel;


    public MainViewImpl() {

        this.listeners = new ArrayList<>();

        final VerticalLayout content = new VerticalLayout();
        header = new VerticalLayout();
        contentPanel = new Panel(content);
        contentPanel.setSizeFull();

        addComponent(header);
        addComponent(contentPanel);

        final VerticalLayout footer = new VerticalLayout(new Label("Footer"));
        final MenuViewImpl menu = new MenuViewImpl();
        addComponent(menu);
        setSizeFull();
        setExpandRatio(contentPanel,1);
        setResponsive(true);

    }

    public Component getHeader() {
        return header;
    }

    public void setHeader(Component header) {
        this.header = header;
    }

    public void setViewContent(Component content) {
        this.contentPanel.setContent(content);
    }

    @Override
    public void addListener(MainViewListener viewListener) {
        listeners.add(viewListener);
    }


}
