package ch.bfh.bti7081.s2017.green.ui.components.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

/**
 * Created by joris on 01.06.17.
 */
@Component
public class PatientPresenter implements PatientViewListener{

    private Patient patient;
    private PatientView patientView;

    @Autowired
    public PatientPresenter(Patient patient, PatientView patientView) {
        this.patient = patient;
        this.patientView = patientView;
        patientView.addListener(this);
        patientView.init(patient.getAll());
    }
}
