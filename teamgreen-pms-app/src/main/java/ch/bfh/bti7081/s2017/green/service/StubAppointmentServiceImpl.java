package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AlarmBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.domain.builder.AlarmBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.AppointmentBuilder;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StubAppointmentServiceImpl implements AppointmentService {
    @Override
    public Set<AppointmentBean> getAll() {
        AppointmentBean bean = new AppointmentBean();
        bean.setEntity(AppointmentBuilder.anAppointment().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }

    @Override
    public long save(AppointmentBean bean) {
        return 0;
    }

    @Override
    public void delete(AppointmentBean bean) {

    }

    @Override
    public AppointmentBean getOne(long id) {
        AppointmentBean bean = new AppointmentBean();
        bean.setEntity(AppointmentBuilder.anAppointment().rundumSorglos().build());
        return bean;
    }
}
