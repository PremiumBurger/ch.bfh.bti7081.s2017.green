package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.menu.MenuViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by joris on 05.05.17.
 */
@SpringUI
@Theme("valo")
public abstract class MasterPageImpl extends AbsoluteLayout implements MasterPage {
    private MasterPageListener listener;
    private VerticalLayout header;
    private VerticalLayout layout;
    private Panel contentPanel;


    public MasterPageImpl() {
        layout = new VerticalLayout();
        header = new VerticalLayout();

        final VerticalLayout content = new VerticalLayout();
        contentPanel = new Panel(content);
        contentPanel.setSizeFull();

        layout.addComponent(header);
        layout.addComponent(contentPanel);

        final MenuViewImpl menu = new MenuViewImpl();
        layout.addComponent(menu);
        layout.setSizeFull();
        layout.setExpandRatio(contentPanel, 1);
        layout.setResponsive(true);

        addComponent(layout);
    }

    public Component getHeader() {
        return header;
    }

    protected void setHeader(Component header) {
        this.header.addComponent(header);
    }

    protected void setViewContent(Component content) {
        this.contentPanel.setContent(content);
    }
}
