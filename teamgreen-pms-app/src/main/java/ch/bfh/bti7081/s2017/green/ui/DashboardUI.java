package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.event.BrowserResizeEvent;
import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Locale;

@SpringUI
@Theme("dashboard")
@Title("QuickTickets Dashboard")
@SuppressWarnings("serial")
public class DashboardUI extends UI {
    /*
       * This field stores an access to the dummy backend layer. In real
       * applications you most likely gain access to your beans trough lookup or
       * injection; and not in the UI but somewhere closer to where they're
       * actually accessed.
       */
    private boolean isLoggedIn = false;

    public DashboardUI () {
        this.isLoggedIn = false;
    }

    @Override
    protected void init (final VaadinRequest request) {
        setLocale(Locale.US);

        //DashboardEventBus.register(this);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

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
            setContent(new MainView());
            removeStyleName("loginview");
            getNavigator().navigateTo(getNavigator().getState());
        } else {
            setContent(new LoginView());
            addStyleName("loginview");
        }
    }

    @Subscribe
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
