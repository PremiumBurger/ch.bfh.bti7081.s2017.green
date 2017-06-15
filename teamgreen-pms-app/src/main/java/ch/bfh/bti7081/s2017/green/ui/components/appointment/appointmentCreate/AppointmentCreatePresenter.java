package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Presenter Class (MVP) for Creating new Appointments
 * @author schms27
 */
@Component
public class AppointmentCreatePresenter implements AppointmentCreateViewListener {

    private AppointmentCreateModel appCreateModel;
    private AppointmentCreateView appCreateView;

    @Autowired
    public AppointmentCreatePresenter(AppointmentCreateModel appCreateModel, AppointmentCreateView appCreateView) {
        this.appCreateModel = appCreateModel;
        this.appCreateView = appCreateView;
        appCreateView.setListener(this);
    }


    @Override
    public void initScreen() {
        AppointmentBean newBean = new AppointmentBean();
        HealthVisitorBean healthVisitor = appCreateModel.getHealthVisitor(1);
        newBean.setHealthVisitor(healthVisitor);
        Set<PatientBean> allPatients = appCreateModel.getAllPatients();
        appCreateView.setModel(newBean, allPatients);
    }

    @Override
    public void saveAppointment(AppointmentBean appointmentBean) {
        // always set new state when create new appointment
        AppointmentStateTypeBean newState = appCreateModel.getAppointmentStateType(PmsConstants.APPOINTMENT_STATE_TPYE_NEW);
        appointmentBean.setAppointmentStateType(newState);

        // save it
        appCreateModel.saveAppointment(appointmentBean);
    }
}
