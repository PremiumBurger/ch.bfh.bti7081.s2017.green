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

    /**
     * Returns a PatientBean
     * @param patientId id of the Patient to get
     * @return the found patient or <code>null</code> if no patient found*/
    public PatientBean getPatient(long patientId){
        return patientService.getOne(patientId);
    }

    /**
     * Returns all Appointments from the patient
     * @param patientId id of the patient
     * @return A List of all Appointments*/
    public List<AppointmentBean> getAllAppointments(long patientId){
        return patientService.getOne(patientId).getAppointments();
    }
}
