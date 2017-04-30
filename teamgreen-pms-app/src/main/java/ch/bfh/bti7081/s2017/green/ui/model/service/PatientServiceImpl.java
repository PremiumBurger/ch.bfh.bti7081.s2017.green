package ch.bfh.bti7081.s2017.green.ui.model.service;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.data.PatientRepository;
import ch.bfh.bti7081.s2017.green.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends BaseService<Patient, PatientBean, PatientRepository> implements PatientService {

    @Autowired
    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
    }

    @Override
    protected Class<PatientBean> getType() {
        return PatientBean.class;
    }
}
