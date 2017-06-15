package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;

/**
 * Interface for Handling the Appointment State Events
 * @author schms27
 */
public interface AppointmentStateEventHandler {

    /**
     * Event to get called whenever a state dependent action has to be executed
     * @param appointmentBean where the state has been changed
     * @param presenter to call actions on
     * @param oldAppointment appointment before change
     */
    void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter);

    /**
     * Event gets called when the State on the appointment has been set/changed
     * @param appointmentBean where the state has been changed
     * @param service to call actions on
     * @param oldAppointment appointment before change
     */
    void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment);

    /**
     * Event to confirm a certain state (stepForward)
     * @param appointmentBean to act on
     * @param presenter to call actions on
     */
    void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter);

    /**
     * Event to cancel/remove a certain state (stepBack)
     * @param appointmentBean to act on
     * @param presenter to call actions on
     */
    void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter);

}
