package ch.bfh.bti7081.s2017.green.ui.components.patients;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * UI Model fo the Patient Structure
 */
@Transactional
@Component
public class Patient {

    /**
     * Declares patientService
     */
    private PatientService patientService;

    /**
     * @param patientService initializes patientService
     */
    public Patient(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * @return List of Patient Beans
     * Gets Patient Beans from patientService, get's called from View
     */
    public List<PatientBean> getAll(){
        return new ArrayList<PatientBean>(patientService.getAll());
    }
}
