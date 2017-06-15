package ch.bfh.bti7081.s2017.green.ui.components.menu;

import ch.bfh.bti7081.s2017.green.ui.navigation.DashboardViewType;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

/**
 * Created by Lukas on 15.06.2017.
 */
public final class ValoMenuItemButton extends Button {

    private static final String STYLE_SELECTED = "selected";

    private final DashboardViewType view;

    public ValoMenuItemButton (final DashboardViewType view) {
        this.view = view;
        setPrimaryStyleName("valo-menu-item");
        setIcon(view.getIcon());
        setCaption(view.getViewName().substring(0, 1).toUpperCase() + view.getViewName().substring(1));
        addClickListener((ClickListener) event -> UI.getCurrent().getNavigator().navigateTo(view.getViewName()));

    }
}
