package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.menu.MenuViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
@SpringUI
@Theme("valo")
public abstract class MasterPageImpl extends VerticalLayout implements MasterPage {
    private List<MasterPageListener> listeners;
    private Component header;

    private Panel contentPanel;


    public MasterPageImpl() {

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
    public void addListener(MasterPageListener viewListener) {
        listeners.add(viewListener);
    }


}
