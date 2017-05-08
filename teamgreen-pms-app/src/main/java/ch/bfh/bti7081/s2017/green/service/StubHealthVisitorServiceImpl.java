package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.domain.builder.AppointmentBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.HealthVisitorBuilder;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StubHealthVisitorServiceImpl implements HealthVisitorService {
    @Override
    public Set<HealthVisitorBean> getAll() {
        HealthVisitorBean bean = new HealthVisitorBean();
        bean.setEntity(HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }

    @Override
    public long save(HealthVisitorBean bean) {
        return 0;
    }

    @Override
    public void delete(HealthVisitorBean bean) {

    }

    @Override
    public HealthVisitorBean getOne(long id) {
        HealthVisitorBean bean = new HealthVisitorBean();
        bean.setEntity(HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build());
        return bean;
    }

    @Override
    public Set<HealthVisitorBean> find(String lastName) {
        HealthVisitorBean bean = new HealthVisitorBean();
        bean.setEntity(HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }
}
