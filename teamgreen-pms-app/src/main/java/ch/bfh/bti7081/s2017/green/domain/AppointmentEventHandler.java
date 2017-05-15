package ch.bfh.bti7081.s2017.green.domain;

/**
 * Created by S.Schmid on 15.05.2017.
 */
public interface AppointmentEventHandler {
    void handleStateAction(Appointment appointment);
}
