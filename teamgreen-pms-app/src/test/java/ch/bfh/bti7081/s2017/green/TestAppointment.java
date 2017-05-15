package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.AppointmentState;
import ch.bfh.bti7081.s2017.green.domain.AppointmentStateIdle;

/**
 * Created by S.Schmid on 15.05.2017.
 */
public class TestAppointment {
    public static void main(String[] args){
        Appointment appointment = new Appointment();
        AppointmentState state = new AppointmentStateIdle();
        state.handleStateAction(appointment);
    }
}
