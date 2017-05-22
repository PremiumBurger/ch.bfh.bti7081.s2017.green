package ch.bfh.bti7081.s2017.green.ui.components.search;

import org.springframework.transaction.annotation.Transactional;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.Patient;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by S.Schmid on 08.05.2017.
 */
@Transactional
@Component
public class Search {

    @Autowired
    private PatientService patientService;


    public Set<PatientBean> getAll() {
        return patientService.getAll();
    }

    public PatientBean getSelection(long id){ return patientService.getOne(id);}

}
