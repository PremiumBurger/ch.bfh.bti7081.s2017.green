package ch.bfh.bti7081.s2017.green.service.appointmentState;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailPresenter;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 * This Class represents the State of a cancelled Appointment
 * @author schms27
 */
public class AppointmentStateCancelled extends AppointmentState {

    @Override
    public void afterStateSet(AppointmentBean appointmentBean, AppointmentBean oldAppointment, AppointmentDetailPresenter presenter) {
        presenter.updateStateButtons(true,"Reactivate",false,"");
    }

    @Override
    public void onStateSet(AppointmentBean appointmentBean, AppointmentService service, AppointmentBean oldAppointment) {
        Notification notif = new Notification(
                "Appointment # " + appointmentBean.getId() + " has been cancelled"
        );
        notif.setDelayMsec(5000);
        notif.setPosition(Position.BOTTOM_CENTER);
        notif.show(Page.getCurrent());
    }

    @Override
    public void confirm(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Get new AppointmentStateTypeBean 'NEW'
        AppointmentStateTypeBean type = presenter.getAppointmentStateTypeBean(1);
        type.setAppointmentState(new AppointmentStateNew());
        appointmentBean.setAppointmentStateType(type);
    }

    @Override
    public void remove(AppointmentBean appointmentBean, AppointmentDetailPresenter presenter) {
        //Do Nothing
    }
}
