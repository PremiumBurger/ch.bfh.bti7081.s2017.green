package ch.bfh.bti7081.s2017.green.ui.view;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class MenuViewImpl implements MenuView {
    private List<MenuView> listeners;

    public MenuViewImpl(List<MenuView> listeners) {
        this.listeners = listeners;
    }
}
