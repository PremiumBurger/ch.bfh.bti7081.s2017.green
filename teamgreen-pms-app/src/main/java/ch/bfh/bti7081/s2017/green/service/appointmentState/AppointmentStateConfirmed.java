package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayPresenter;

/**
 * Created by simon.schmid on 12.06.2017.
 */
public class AppointmentStateConfirmed extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {

    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {

    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'FINISHED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(5);
        type.setAppointmentState(new AppointmentStateConfirmed());
        appointmentBean.setAppointmentStateType(type);
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CANCELLED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(3);
        type.setAppointmentState(new AppointmentStateConfirmed());
        appointmentBean.setAppointmentStateType(type);
    }
}
