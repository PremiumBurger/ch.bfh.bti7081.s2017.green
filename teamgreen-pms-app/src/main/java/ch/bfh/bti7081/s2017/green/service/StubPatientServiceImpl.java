package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.PatientBuilder;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StubPatientServiceImpl implements PatientService {

    @Override
    public Set<PatientBean> getAll() {
        PatientBean bean = new PatientBean();
        bean.setEntity(PatientBuilder.aPatient().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }

    @Override
    public long save(PatientBean bean) {
        return 0;
    }

    @Override
    public void delete(PatientBean bean) {

    }

    @Override
    public PatientBean getOne(long id) {
        PatientBean bean = new PatientBean();
        bean.setEntity(PatientBuilder.aPatient().rundumSorglos().build());
        return bean;
    }
}
