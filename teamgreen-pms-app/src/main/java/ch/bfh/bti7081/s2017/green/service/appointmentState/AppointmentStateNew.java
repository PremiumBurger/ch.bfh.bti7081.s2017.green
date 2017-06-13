package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import com.vaadin.ui.Notification;

import java.time.LocalDateTime;

/**
 * This Class represents the State of a new Appointment
 * @author schms27
 */
public class AppointmentStateNew extends AppointmentState {


    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentServiceImpl service, AppointmentBean oldAppointment) {
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
    public void confirm(AppointmentBean appointmentBean, AppointmentService service) {
        //Get new AppointmentStateTypeBean 'CONFIRMED'
        //AppointmentStateTypeBean type = service.getStateTypeService().getOne(4);
        //type.setAppointmentState(new AppointmentStateConfirmed());
        //appointmentBean.setAppointmentStateType(type);
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentService service) {
        //Get new AppointmentStateTypeBean 'CANCELLED'
        //AppointmentStateTypeBean type = service.getStateTypeService().getOne(3);
        //type.setAppointmentState(new AppointmentStateCancelled());
        //appointmentBean.setAppointmentStateType(type);
    }
}
