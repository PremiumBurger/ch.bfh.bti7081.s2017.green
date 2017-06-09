package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by mathewthekkekara on 06.06.17.
 */
@Component
public class PatientDetailPresenter implements PatientDetailViewListener {

    private PatientDetailModel patientDetail;
    private PatientDetailView patientDetailView;

    @Autowired
    public PatientDetailPresenter(PatientDetailModel patientDetail, PatientDetailView patientDetailView){
        this.patientDetail = patientDetail;
        this.patientDetailView = patientDetailView;
        patientDetailView.addListener(this);
    }

    @Override
    public void getData() {

    }

    @Override
    public void initScreen(long patientId) {
        PatientBean pb = patientDetail.getPatient(patientId);
        List<AppointmentBean> set = patientDetail.getAllAppointments(patientId);
        patientDetailView.setModel(pb,set);
    }
}