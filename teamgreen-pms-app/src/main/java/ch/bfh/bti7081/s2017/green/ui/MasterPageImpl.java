package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.menu.MenuViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Implementation of the Master Page to Display other Components and Views
 * Created by joris on 05.05.17.
 * @author joris
 * @author ladel1
 * @author schms27
 */
@SpringUI
@Theme("valo")
public abstract class MasterPageImpl extends AbsoluteLayout implements MasterPage {
    //Variable Declaration
    private MasterPageListener listener;        //TODO: What do we need this Listener for?
    private VerticalLayout header;              //Use Vertical Layout for Header instead Panel because it's invisible
    private VerticalLayout layout;              //Layout Component to set all the other Components to
    private Panel contentPanel;                 //Container for the Content


    public MasterPageImpl() {
        layout = new VerticalLayout();
        header = new VerticalLayout();

        final VerticalLayout content = new VerticalLayout();
        contentPanel = new Panel(content);
        contentPanel.setSizeFull();

        //Assemble UI Components
        layout.addComponent(header);
        layout.addComponent(contentPanel);

        final MenuViewImpl menu = new MenuViewImpl();
        layout.addComponent(menu);
        layout.setSizeFull();
        layout.setExpandRatio(contentPanel, 1);
        layout.setResponsive(true);

        addComponent(layout);
    }
    /**
     * Returns the current Header
     */
    public Component getHeader() {
        return header;
    }

    /**
     * Sets the Header on top of the Mainpage
     * @param header a Vaadin Component to be set as Header
     */
    protected void setHeader(Component header) {
        this.header.addComponent(header);
    }
    /**
     * Sets the Content of the Mainpage
     * @param content a Vaadin Component to be set as Main Content
     */
    protected void setViewContent(Component content) {
        this.contentPanel.setContent(content);
    }
}
