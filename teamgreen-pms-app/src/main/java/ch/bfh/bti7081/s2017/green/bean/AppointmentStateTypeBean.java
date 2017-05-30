package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState.AppointmentState;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState.AppointmentStateEventHandler;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState.AppointmentStateNew;

/**
 * Created by Simu on 18.05.2017 for Project ch.bfh.bti7081.s2017.green.
 * TEstbeschreibung
 */
public class AppointmentStateTypeBean extends EntityBean<AppointmentStateType> implements AppointmentStateEventHandler{

    private AppointmentState appointmentState;

    public AppointmentStateTypeBean(){
        appointmentState = new AppointmentStateNew();
    }

    public AppointmentStateTypeBean(AppointmentState appointmentState){
        this.appointmentState = appointmentState;
    }

    public void setAppointmentState(AppointmentState appointmentState) {
        this.appointmentState = appointmentState;
    }

    public AppointmentState getAppointmentState() {
        return appointmentState;
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().onStateSet(appointmentBean);
    }
}
