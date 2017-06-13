package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;

/**
 * Created by simon.schmid on 12.06.2017.
 */
public class AppointmentStateConfirmed extends AppointmentState {

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentServiceImpl service, AppointmentBean oldAppointment) {

    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentServiceImpl service) {

    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentServiceImpl service) {
        appointmentBean.getAppointmentStateType().setAppointmentState(new AppointmentStateCancelled());
    }
}
