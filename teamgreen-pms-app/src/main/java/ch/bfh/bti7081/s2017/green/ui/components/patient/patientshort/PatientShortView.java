package ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;

/**
 * Created by joris on 15.05.17.
 */
public interface PatientShortView extends View{
    void addListener(PatientShortListener listener);



    void init(PatientBean patient);
}
