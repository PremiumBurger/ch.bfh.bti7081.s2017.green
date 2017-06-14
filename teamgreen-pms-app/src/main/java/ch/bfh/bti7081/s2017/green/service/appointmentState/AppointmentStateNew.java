package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayPresenter;
import com.vaadin.ui.Notification;

import java.time.LocalDateTime;

/**
 * This Class represents the State of a new Appointment
 * @author schms27
 */
public class AppointmentStateNew extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {

    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {
        LocalDateTime ldtFromBefore = oldAppointment.getFrom();
        LocalDateTime ldtToBefore = oldAppointment.getTo();
        LocalDateTime ldtFromAfter = appointmentBean.getFrom();
        LocalDateTime ldtToAfter = appointmentBean.getTo();
        if(!ldtFromBefore.isEqual(ldtFromAfter) || !ldtToBefore.isEqual(ldtToAfter)){
            AppointmentStateTypeBean type = service.getStateTypeService().getOne(2);
            type.setAppointmentState(new AppointmentStatePostponed());
            appointmentBean.setAppointmentStateType(type);
        }
        //service.onStateSetToNew();
        Notification.show("State New has been set");
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CONFIRMED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(4);
        type.setAppointmentState(new AppointmentStateConfirmed());
        appointmentBean.setAppointmentStateType(type);
        presenter.updateCancelButton(true,"Cancel Appointment");
        presenter.updateConfirmButton(true,"Finish Appointment");
        //presenter.initScreen(appointmentBean.getId());
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CANCELLED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(3);
        type.setAppointmentState(new AppointmentStateCancelled());
        appointmentBean.setAppointmentStateType(type);
        presenter.updateCancelButton(false,"");
        presenter.updateConfirmButton(true,"Reactivate");
    }
}
