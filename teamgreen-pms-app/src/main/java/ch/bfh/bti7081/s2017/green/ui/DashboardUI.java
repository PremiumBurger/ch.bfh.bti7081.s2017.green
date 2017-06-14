package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.event.UserContexteCreated;
import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginView;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginViewImpl;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import green.auth.UserContext;
import green.event.EventBus;
import green.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@SpringUI
@Theme("dashboard")
@Title("PMS")
@Push
@PreserveOnRefresh
@SuppressWarnings("serial")
public class DashboardUI extends UI {
    private LoginView loginView;
    private MainView mainView;
    private EventBus eventBus;
    private UserContext userContext;
    private HealthVisitorService healthVisitorService;

    @Autowired
    public DashboardUI (LoginView loginView, MainView mainView, EventBus eventBus, UserContext userContext, HealthVisitorService healthVisitorService) {
        this.loginView = loginView;
        this.mainView = mainView;
        this.eventBus = eventBus;
        this.userContext = userContext;
        this.healthVisitorService = healthVisitorService;
    }

    @Override
    protected void init (final VaadinRequest request) {
        setLocale(Locale.US);
        VaadinSession.getCurrent().setErrorHandler((ErrorHandler) errorEvent -> {});
        eventBus.addHandler(this);

        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);
        this.mainView.onAfterBeanInitializaiton();
        this.loginView.onAfterBeanInitializaiton();
        updateContent();
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent () {
        if (this.userContext.isAuthenticated()) {
            setContent(mainView);
            removeStyleName("loginview");
            Navigator navigator = getNavigator();
            navigator.navigateTo(navigator.getState());
            eventBus.fireEvent(new UserContexteCreated());
        } else {
            setContent((LoginViewImpl)loginView);
            addStyleName("loginview");
        }
    }

    @EventHandler
    public void userLoginRequested (UserLoginRequestedEvent userLoginRequest) {
        if (!userLoginRequest.hasProfile()) {
            updateContent();
            return;
        }

        HealthVisitorBean user = healthVisitorService.get(userLoginRequest.getIdentifier());
        if (user == null) {
            user = healthVisitorService.createFromUserContext(userLoginRequest);
        }
        this.userContext.setUserContext(user.getId(), user.getFirstName(), user.getLastName(), user.getExternalKey(), userLoginRequest.getImageUrl());

        updateContent();
    }
}
