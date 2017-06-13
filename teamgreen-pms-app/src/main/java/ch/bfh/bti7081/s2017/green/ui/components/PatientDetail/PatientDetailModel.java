package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathewthekkekara on 06.06.17.
 */
@Transactional
@Component
public class PatientDetailModel {
    private PatientService patientService;

    @Autowired
    public PatientDetailModel(PatientService patientService) {
        this.patientService = patientService;
    }

    public PatientBean getPatient(long patientId){
        return patientService.getOne(patientId);
    }

    public List<AppointmentBean> getAllAppointments(long patientId){
        return patientService.getOne(patientId).getAppointments();
    }
}
