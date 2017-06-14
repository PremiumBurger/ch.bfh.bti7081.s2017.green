package ch.bfh.bti7081.s2017.green.ui.components.menu;

/**
 * Created by Lukas on 26.05.2017.
 */

import ch.bfh.bti7081.s2017.green.event.UserContexteCreated;
import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import ch.bfh.bti7081.s2017.green.ui.DashboardViewType;
import ch.bfh.bti7081.s2017.green.ui.controls.LinkButton;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import green.auth.UserContext;
import green.event.EventBus;
import green.event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A responsive menu component providing user information and the controls for
 * primary navigation between the views.
 */
@SuppressWarnings({"serial", "unchecked"})
@org.springframework.stereotype.Component
public final class MenuViewImpl extends CustomComponent {

    public static final String ID = "dashboard-menu";
    public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
    private static final String STYLE_VISIBLE = "valo-menu-visible";
    private Label notificationsBadge;
    private MenuBar.MenuItem settingsItem;
    private UserContext userContext;
    private EventBus eventBus;

    @Autowired
    public MenuViewImpl (UserContext userContext, EventBus eventBus) {
        this.userContext = userContext;
        this.eventBus = eventBus;
        eventBus.addHandler(this);
        setPrimaryStyleName("valo-menu");
        setId(ID);
        setSizeUndefined();
        setCompositionRoot(buildContent());
    }

    private Component buildContent () {
        final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName("no-vertical-drag-hints");
        menuContent.addStyleName("no-horizontal-drag-hints");
        menuContent.setWidth(null);
        menuContent.setHeight("100%");

        menuContent.addComponent(buildTitle());
        menuContent.addComponent(buildUserMenu());
        menuContent.addComponent(buildToggleButton());
        menuContent.addComponent(buildMenuItems());

        return menuContent;
    }

    private Component buildTitle () {
        Label logo = new Label("PMS <strong>B.O.O.B.S</strong>", ContentMode.HTML);
        logo.setSizeUndefined();
        HorizontalLayout logoWrapper = new HorizontalLayout(logo);
        logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        logoWrapper.addStyleName("valo-menu-title");
        logoWrapper.setSpacing(false);
        return logoWrapper;
    }

    @EventHandler
    public void updateUserName (UserContexteCreated userContexteCreated) {
        if (userContext.isAuthenticated()) {
            settingsItem.setText(userContext.getFirstname() + " " + userContext.getLastname());
        }

        Resource userIcon = userContext.isAuthenticated() ? new ExternalResource(userContext.getImageUrl()) : new ThemeResource("img/profile-pic-300px.jpg");
        settingsItem.setIcon(userIcon);
    }

    private Component buildUserMenu () {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        settingsItem = settings.addItem("", new ThemeResource("img/profile-pic-300px.jpg"), null);
        updateUserName(null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", new MenuBar.Command() {
            @Override
            public void menuSelected (final MenuBar.MenuItem selectedItem) {
                userContext.logout();
                eventBus.fireEvent(new UserLoginRequestedEvent(null));
            }
        });
        return settings;
    }

    private Component buildToggleButton () {
        Button valoMenuToggleButton;
        valoMenuToggleButton = new Button("Menu", (Button.ClickListener) event -> {
            if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
                getCompositionRoot().removeStyleName(STYLE_VISIBLE);
            } else {
                getCompositionRoot().addStyleName(STYLE_VISIBLE);
            }
        });
        valoMenuToggleButton.setIcon(VaadinIcons.LIST);
        valoMenuToggleButton.addStyleName("valo-menu-toggle");
        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
        return valoMenuToggleButton;
    }

    private Component buildMenuItems () {
        CssLayout menuItemsLayout = new CssLayout();
        menuItemsLayout.addStyleName("valo-menuitems");

        for (final DashboardViewType view : DashboardViewType.values()) {
            Component menuItemComponent = new ValoMenuItemButton(view);

            if (view == DashboardViewType.MYDAY) {
                notificationsBadge = new Label();
                notificationsBadge.setId(NOTIFICATIONS_BADGE_ID);
                menuItemComponent = buildBadgeWrapper(menuItemComponent, notificationsBadge);
            }

            if (view.showInMainNavigation()) {
                menuItemsLayout.addComponent(menuItemComponent);
            }
        }
        menuItemsLayout.addComponent(buildAlarmButton());
        return menuItemsLayout;

    }

    private Component buildBadgeWrapper (final Component menuItemButton, final Component badgeLabel) {
        CssLayout dashboardWrapper = new CssLayout(menuItemButton);
        dashboardWrapper.addStyleName("badgewrapper");
        dashboardWrapper.addStyleName(ValoTheme.MENU_ITEM);
        badgeLabel.addStyleName(ValoTheme.MENU_BADGE);
        badgeLabel.setWidthUndefined();
        badgeLabel.setVisible(false);
        dashboardWrapper.addComponent(badgeLabel);
        return dashboardWrapper;
    }

    @Override
    public void attach () {
        super.attach();
    }

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
    private Component buildAlarmButton(){
        VerticalLayout alarmLayout = new VerticalLayout();
        LinkButton alarmbutton = new LinkButton("Alarm!", new ExternalResource("tel:0774099434"));
        alarmLayout.addComponent(alarmbutton);
        return alarmLayout;
    }
}
