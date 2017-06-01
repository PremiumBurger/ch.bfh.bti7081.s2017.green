package ch.bfh.bti7081.s2017.green.ui.components.patients;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 01.06.17.
 */
@Transactional
@Component
public class Patient {
    private PatientService patientService;

    public Patient(PatientService patientService) {
        this.patientService = patientService;
    }

    public List<PatientBean> getAll(){
        return new ArrayList<PatientBean>(patientService.getAll());
    }
}
