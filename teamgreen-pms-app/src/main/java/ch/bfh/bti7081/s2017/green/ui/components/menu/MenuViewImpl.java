package ch.bfh.bti7081.s2017.green.ui.components.menu;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

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
        //alarm.addClickListener(e -> MainUI.navigator.navigateTo("alarmView"));
        Button home = new Button("Home");
        //home.addClickListener(e -> MainUI.navigator.navigateTo(""));
        home.setIcon(VaadinIcons.HOME);
        alarm.setIcon(VaadinIcons.AMBULANCE);
        alarm.setStyleName("primary");
        alarm.setWidth("100%");
        home.setWidth("100%");
        addComponents(alarm, home);
        setWidth("100%");
        setResponsive(true);

    }


    @Override
    public void addListener(MenuViewListener viewListener) {
        listeners.add(viewListener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
