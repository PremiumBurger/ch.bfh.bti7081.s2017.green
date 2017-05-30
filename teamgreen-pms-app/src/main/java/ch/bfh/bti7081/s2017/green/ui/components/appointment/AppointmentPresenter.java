package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
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

        appointmentView.addListener(this);
    }



    @Override
    public void save(AppointmentBean appointmentBean) {
        appointment.save(appointmentBean);
    }
    public void getData(long id){
        appointmentView.init(appointment.getSelectedAppointment(id), appointment.getAllPatients());
    }
}
