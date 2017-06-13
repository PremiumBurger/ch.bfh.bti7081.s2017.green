package ch.bfh.bti7081.s2017.green.ui.components.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;


/**
 * Connects Model and View
 * Implements PatientViewListener
 */
@Component
public class PatientPresenter implements PatientViewListener{

    /**
     * Declaration of myDayView
     * Access to MyDay Model
     */
    private Patient patient;

    /**
     * Declaration of myDayView
     * Access to MyDay View
     */
    private PatientView patientView;

    /**
     * @param patient Initializes Model through Spring Autowired
     * @param patientView Initializes View through Spring Autowired
     * Adds this presenter to the view
     */
    @Autowired
    public PatientPresenter(Patient patient, PatientView patientView) {
        this.patient = patient;
        this.patientView = patientView;
        patientView.addListener(this);
        patientView.init(patient.getAll());
    }
}
