package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of a cancelled Appointment
 * @author schms27
 */
public class AppointmentStateCancelled extends AppointmentState {

    public AppointmentStateCancelled(){
        this.setDescription("CANCELLED");
    }

    @Override
    public void onStateSet(AppointmentBean appointment) {
        Notification.show("State Cancelled has been set");
    }
}
