package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;


public interface AppointmentCreateViewListener {

    /**
     * Gets the initial Data for this Screen
     */
    void initScreen();


    /**
     * Persists an {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    void saveAppointment(AppointmentBean appointmentBean);
}
