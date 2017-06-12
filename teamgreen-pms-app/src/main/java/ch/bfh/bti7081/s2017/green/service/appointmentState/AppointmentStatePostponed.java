package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of the Appointment, when it has been postponed
 * @author schms27
 */
public class AppointmentStatePostponed extends AppointmentState {
    @Override
    public void onStateSet(AppointmentBean appointment) {
        Notification.show("State Postponed has been set");
    }
}
