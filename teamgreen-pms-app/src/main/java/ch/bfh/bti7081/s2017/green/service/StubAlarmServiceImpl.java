package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.AlarmBean;
import ch.bfh.bti7081.s2017.green.domain.builder.AddressBuilder;
import ch.bfh.bti7081.s2017.green.domain.builder.AlarmBuilder;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StubAlarmServiceImpl implements AlarmService {
    @Override
    public Set<AlarmBean> getAll() {
        AlarmBean bean = new AlarmBean();
        bean.setEntity(AlarmBuilder.anAlarm().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }

    @Override
    public long save(AlarmBean bean) {
        return 0;
    }

    @Override
    public void delete(AlarmBean bean) {

    }

    @Override
    public AlarmBean getOne(long id) {
        AlarmBean bean = new AlarmBean();
        bean.setEntity(AlarmBuilder.anAlarm().rundumSorglos().build());
        return bean;
    }
}
