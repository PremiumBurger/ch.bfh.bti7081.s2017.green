package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

public interface AppointmentDetailViewListener {

    /**
     * Gets the initial Data for this Screen
     * @param appointmentId the appointmentId
     */
    void initScreen(long appointmentId);


    /**
     * Persists an {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    void saveAppointment(AppointmentBean appointmentBean);

}
