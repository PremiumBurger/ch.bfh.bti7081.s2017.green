package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of a cancelled Appointment
 * @author schms27
 */
public class AppointmentStateCancelled extends AppointmentState {

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentServiceImpl service, AppointmentBean oldAppointment) {
        Notification.show("State Cancelled has been set");
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentServiceImpl service) {

    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentServiceImpl service) {

    }
}