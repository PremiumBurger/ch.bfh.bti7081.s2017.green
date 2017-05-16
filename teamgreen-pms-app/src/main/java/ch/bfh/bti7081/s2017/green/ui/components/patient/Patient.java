package ch.bfh.bti7081.s2017.green.ui.components.patient;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 16.05.17.
 */
@Component
public class Patient {

    private PatientService service;

    @Autowired
    public Patient(PatientService service) {
        this.service = service;
    }

    public PatientBean getSelectedPatient() {
        return service.getAll().stream().findFirst().get();
    }
}
