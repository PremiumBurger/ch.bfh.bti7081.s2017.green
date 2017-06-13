package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentServiceImpl;
import ch.bfh.bti7081.s2017.green.service.AppointmentStateTypeServiceImpl;
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
        service.onStateSetToNew();
        Notification.show("State New has been set");
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentServiceImpl service) {
        appointmentBean.getAppointmentStateType().setAppointmentState(new AppointmentStateConfirmed());
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentServiceImpl service) {
        appointmentBean.getAppointmentStateType().setAppointmentState(new AppointmentStateCancelled());
    }
}
