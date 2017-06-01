package ch.bfh.bti7081.s2017.green.ui;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Lukas on 26.05.2017.
 * /*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */
@SuppressWarnings("serial")
@Component
public class MainView extends HorizontalLayout {

    private ComponentContainer content;
    private ApplicationContext context;

    @Autowired
    public MainView(ApplicationContext context) {
        this.context = context;
        setSizeFull();
        addStyleName("mainview");
        setSpacing(false);
        addComponent(new DashboardMenu());
        content = new CssLayout();
        content.addStyleName("v-scrollable");
        content.setHeight("100%");
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);
    }

    public void onAfterBeanInitializaiton() {
        new DashboardNavigator(this.context, this.content);
    }

}