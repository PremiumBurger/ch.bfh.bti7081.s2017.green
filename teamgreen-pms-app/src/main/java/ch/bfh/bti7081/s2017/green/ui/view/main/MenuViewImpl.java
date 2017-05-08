package ch.bfh.bti7081.s2017.green.ui.view.main;

import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
@SpringUI
@Theme("valo")
public class MenuViewImpl extends HorizontalLayout implements MenuView {
    private List<MenuViewListener> listeners;

    public MenuViewImpl() {
        this.listeners = new ArrayList<>();
        Button alarm = new Button("Alarm");
        Button home = new Button("Home");
        //alarm.addClickListener(event -> new)
        alarm.setWidth("100%");
        home.setWidth("100%");
        this.addComponent(alarm);
        this.addComponent(home);

        this.setSizeFull();
        setResponsive(true);

    }


    @Override
    public void addListener(MenuViewListener viewListener) {
        listeners.add(viewListener);
    }
}
