package ch.bfh.bti7081.s2017.green.ui.view;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class MenuViewImpl implements MenuView {
    private List<MenuViewListener> listeners;

    public MenuViewImpl(List<MenuViewListener> listeners) {
        this.listeners = listeners;
    }
}
