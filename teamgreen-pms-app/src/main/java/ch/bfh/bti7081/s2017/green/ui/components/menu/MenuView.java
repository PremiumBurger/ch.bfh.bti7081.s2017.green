package ch.bfh.bti7081.s2017.green.ui.components.menu;

import com.vaadin.navigator.View;

/**
 * Created by joris on 05.05.17.
 */

public interface MenuView extends View{
    void addListener(MenuViewListener viewListener);
}
