package ch.bfh.bti7081.s2017.green.ui.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class MenuViewImpl extends CustomComponent implements MenuView {
    private List<MenuViewListener> listeners;

    public MenuViewImpl(List<MenuViewListener> listeners) {
        this.listeners = listeners;

        VerticalLayout vertical = new VerticalLayout ();
        Button homeButton = new Button("Home");
        vertical.setResponsive(true);

    }

    @Override
    public void addListener(MenuViewListener viewListener) {
        listeners.add(viewListener);
    }
}
