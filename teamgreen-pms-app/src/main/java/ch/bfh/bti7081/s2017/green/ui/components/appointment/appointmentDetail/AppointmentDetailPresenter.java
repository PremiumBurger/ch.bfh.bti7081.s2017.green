package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppointmentDetailPresenter implements AppointmentDetailViewListener {

    private AppointmentDetailModel appDetailModel;
    private AppointmentDetailView appDetailView;

    @Autowired
    public AppointmentDetailPresenter(AppointmentDetailModel appDetailModel, AppointmentDetailView appDetailView) {
        this.appDetailModel = appDetailModel;
        this.appDetailView = appDetailView;
        appDetailView.setListener(this);
    }

    @Override
    public void initScreen(long appointmentId) {
        AppointmentBean foundBean = appDetailModel.getAppointment(appointmentId);
        Set<PatientBean> allPatients = appDetailModel.getAllPatients();
        Set<AppointmentStateTypeBean> allAppointmentStateTypes = appDetailModel.getAllAppointmentStateTypes();
        appDetailView.setModel(foundBean, allPatients, allAppointmentStateTypes);
    }

    @Override
    public void saveAppointment(AppointmentBean appointmentBean) {
        appDetailModel.saveAppointment(appointmentBean);
    }
}
