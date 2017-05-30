package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of a new Appointment
 * @author schms27
 */
public class AppointmentStateNew extends AppointmentState {

    public AppointmentStateNew(){
        this.setDescription("NEW");
    }

    @Override
    public void onStateSet(AppointmentBean appointment) {
        Notification.show("State New has been set");
    }
}
