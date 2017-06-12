package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import ch.bfh.bti7081.s2017.green.service.appointmentState.AppointmentState;
import ch.bfh.bti7081.s2017.green.service.appointmentState.AppointmentStateEventHandler;
import ch.bfh.bti7081.s2017.green.service.appointmentState.AppointmentStateNew;

/**
 * Bean Class Appointment State Type
 * @author schms27
 */
public class AppointmentStateTypeBean extends EntityBean<AppointmentStateType> implements AppointmentStateEventHandler{

    private AppointmentState appointmentState;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean) {
        appointmentBean.getAppointmentStateType().getAppointmentState().onStateSet(appointmentBean);
    }
}
