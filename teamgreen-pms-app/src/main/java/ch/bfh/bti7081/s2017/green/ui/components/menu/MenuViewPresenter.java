package ch.bfh.bti7081.s2017.green.ui.components.menu;

import ch.bfh.bti7081.s2017.green.event.UserContexteCreated;
import green.auth.UserContext;
import green.event.EventBus;
import green.event.EventHandler;

/**
 * Created by Lukas on 15.06.2017.
 */
public class MenuViewPresenter {
    private MenuView view;
    private Menu menu;
    private UserContext userContext;
    private EventBus eventBus;

    public MenuViewPresenter (MenuView view, Menu menu, UserContext userContext, EventBus eventBus) {
        this.view = view;
        this.menu = menu;
        this.userContext = userContext;
        this.eventBus = eventBus;
        this.eventBus.addHandler(this);
    }

    @EventHandler
    public void updateUserName (UserContexteCreated userContexteCreated) {
        view.updateUserMenu(userContext);
    }
}
