package ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort;

import ch.bfh.bti7081.s2017.green.ui.components.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 16.05.17.
 */
@Component
public class PatientViewPresenter implements PatientShortListener {
    private Patient patient;                //Model
    private PatientShortView patientShortView;        //View

    @Autowired
    public PatientViewPresenter(PatientShortView patientShortView, Patient patient) {
        this.patientShortView = patientShortView;
        this.patient = patient;
        patientShortView.addListener(this);
        patientShortView.init(patient.getSelectedPatient());
    }
}
