package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 26.05.17.
 */
@Component
public class AppointmentPresenter implements AppointmentViewListener {

    AppointmentView appointmentView;
    Appointment appointment;

    @Autowired
    public AppointmentPresenter(AppointmentView appointmentView, Appointment appointment) {
        this.appointmentView = appointmentView;
        this.appointment = appointment;
        appointmentView.init(appointment.getSelectedAppointment(), appointment.getAllPatients());
        appointmentView.addListener(this);
    }


}
