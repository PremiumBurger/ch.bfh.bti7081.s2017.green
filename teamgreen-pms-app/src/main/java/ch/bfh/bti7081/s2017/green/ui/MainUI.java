package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.Alarm.AlarmView;
import ch.bfh.bti7081.s2017.green.ui.components.address.AddressView;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.AppointmentView;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginView;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayView;
import ch.bfh.bti7081.s2017.green.ui.components.login.LoginView;
import ch.bfh.bti7081.s2017.green.ui.components.search.SearchView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class MainUI extends UI {

    @Autowired
    private LoginView loginView;

    @Autowired
    private AddressView addressView;

    @Autowired
    private SearchView searchView;

    @Autowired
    private MyDayView myDayView;

    @Autowired
    private AppointmentView appointmentView;

    @Autowired
    private AlarmView alarmView;

    public static Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this,this);
        navigator.addView("asdf", loginView);
        navigator.addView("addressView", addressView);
        navigator.addView("alarmView", alarmView);
        navigator.addView("aaaa", myDayView);
        navigator.addView("appointmentview", appointmentView);
        navigator.addView("", searchView);
    }
}
