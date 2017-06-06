package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

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
    public void initScreen(long healthVisitorId) {

        AppointmentBean newBean = new AppointmentBean();
        HealthVisitorBean healthVisitor = appCreateModel.getHealthVisitor(healthVisitorId);
        AppointmentStateTypeBean appointmentStateType = appCreateModel.getAppointmentStateType(1);
        newBean.setHealthVisitor(healthVisitor);
        newBean.setAppointmentStateType(appointmentStateType);
        Set<PatientBean> allPatients = appCreateModel.getAllPatients();
        Set<AppointmentStateTypeBean> allAppointmentStateTypes = appCreateModel.getAllAppointmentStateTypes();
        appCreateView.setModel(newBean, allPatients, allAppointmentStateTypes);
    }

    @Override
    public void saveAppointment(AppointmentBean appointmentBean) {
        appCreateModel.saveAppointment(appointmentBean);
    }
}
