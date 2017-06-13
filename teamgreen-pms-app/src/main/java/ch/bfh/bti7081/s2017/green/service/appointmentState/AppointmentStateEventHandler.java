package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;

/**
 * Interface for Handling the Appointment State Events
 * @author schms27
 */
public interface AppointmentStateEventHandler {


    /**
     * Event to get called when the State on the appointment has been set/changed
     * @param appointmentBean where the state has been changed
     * @param service to call actions on
     * @param oldAppointment appointment before change
     */
    void onStateSet(AppointmentBean appointmentBean, AppointmentServiceImpl service, AppointmentBean oldAppointment);

    void confirm(AppointmentBean appointmentBean, AppointmentService service);

    void remove(AppointmentBean appointmentBean, AppointmentService service);

}
