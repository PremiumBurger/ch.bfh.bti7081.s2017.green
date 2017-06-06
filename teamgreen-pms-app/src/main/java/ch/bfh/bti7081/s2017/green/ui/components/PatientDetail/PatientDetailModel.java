package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.stereotype.Component;

/**
 * Created by mathewthekkekara on 06.06.17.
 */
@Component
public class PatientDetailModel {
    private PatientService patientService;

    public void getPatient(long id){
        patientService.getOne(id);
    }
}
