package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;

import java.time.LocalDateTime;

/**
 * This Class represents the State of a new Appointment
 * @author schms27
 */
public class AppointmentStateNew extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {
        presenter.updateStateButtons(true,"Confirm Appointment",true,"Cancel Appointment");
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {
        LocalDateTime ldtFromBefore = oldAppointment.getFrom();
        LocalDateTime ldtToBefore = oldAppointment.getTo();
        LocalDateTime ldtFromAfter = appointmentBean.getFrom();
        LocalDateTime ldtToAfter = appointmentBean.getTo();
        if(ldtToBefore==null || ldtFromBefore == null || ldtToAfter==null || ldtFromAfter==null)return;
        if(!ldtFromBefore.isEqual(ldtFromAfter) || !ldtToBefore.isEqual(ldtToAfter)){
            AppointmentStateTypeBean type = service.getStateTypeService().getOne(2);
            type.setAppointmentState(new AppointmentStatePostponed());
            appointmentBean.setAppointmentStateType(type);
        }
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CONFIRMED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(4);
        type.setAppointmentState(new AppointmentStateConfirmed());
        appointmentBean.setAppointmentStateType(type);
        //presenter.updateStateButtons(true,"Finish Appointment",true,"Cancel Appointment");
        //presenter.initScreen(appointmentBean.getId());
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'CANCELLED'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(3);
        type.setAppointmentState(new AppointmentStateCancelled());
        appointmentBean.setAppointmentStateType(type);
        //presenter.updateStateButtons(true,"Reactivate",false,"");
    }
}
