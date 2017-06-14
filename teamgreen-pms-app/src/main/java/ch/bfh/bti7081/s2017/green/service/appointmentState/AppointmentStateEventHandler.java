package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate.AppointmentCreatePresenter;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayPresenter;

/**
 * Interface for Handling the Appointment State Events
 * @author schms27
 */
public interface AppointmentStateEventHandler {


    /**
     * Event to get called when the State on the appointment has been set/changed
     * @param appointmentBean where the state has been changed
     * @param presenter to call actions on
     * @param oldAppointment appointment before change
     */
    void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter);

    void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment);

    void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter);

    void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter);

}
