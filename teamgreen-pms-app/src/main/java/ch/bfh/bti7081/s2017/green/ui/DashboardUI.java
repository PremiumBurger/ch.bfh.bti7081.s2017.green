package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import green.mvp.event.EventBus;
import green.mvp.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@SpringUI
@Theme("dashboard")
@Title("PMS")
@SuppressWarnings("serial")
public class DashboardUI extends UI {
    private LoginView loginView;
    private MainView mainView;
    private EventBus eventBus;

    private boolean isLoggedIn = false;

    public DashboardUI () {
        this.isLoggedIn = false;
    }

    @Autowired
    public DashboardUI (LoginView loginView, MainView mainView, EventBus eventBus) {
        this.loginView = loginView;
        this.mainView = mainView;
        this.eventBus = eventBus;
    }

    @Override
    protected void init (final VaadinRequest request) {
        setLocale(Locale.US);
        eventBus.addHandler(this);

        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);
        this.mainView.onAfterBeanInitializaiton();
        this.loginView.onAfterBeanInitializaiton();
        updateContent();

        // Some views need to be aware of browser resize events so a
        // BrowserResizeEvent gets fired to the event bus on every occasion.
        // Page.getCurrent().addBrowserWindowResizeListener((Page.BrowserWindowResizeListener) event -> DashboardEventBus.post(new BrowserResizeEvent()));
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent () {
        //User user = (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
        //if (user != null && "admin".equals(user.getRole())) {
        if (isLoggedIn) {
            // Authenticated user
            setContent(mainView);
            removeStyleName("loginview");
            Navigator navigator = getNavigator();
            navigator.navigateTo(navigator.getState());
        } else {
            setContent(loginView);
            addStyleName("loginview");
        }
    }

    @EventHandler
    public void userLoginRequested (UserLoginRequestedEvent userLoginRequest) {
        /*User user = getDataProvider().authenticate(event.getUserName(), event.getPassword());
        VaadinSession.getCurrent().setAttribute(User.class.getName(), user);*/
        isLoggedIn = true;
        updateContent();
    }

    /*@Subscribe
    public void userLoggedOut(final UserLoggedOutEvent event) {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

    @Subscribe
    public void closeOpenWindows(final CloseOpenWindowsEvent event) {
        for (Window window : getWindows()) {
            window.close();
        }
    }*/
}
