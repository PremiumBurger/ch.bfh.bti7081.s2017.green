package ch.bfh.bti7081.s2017.green.domain;

/**
 * Created by S.Schmid on 15.05.2017.
 */
public class AppointmentStateIdle extends AppointmentState {


    @Override
    public void handleStateAction(Appointment appointment) {
        System.out.println("Appointment is in idle state");
        appointment.setState(this);
    }

    public String toString(){
        return "Appointment Idle State";
    }
}
