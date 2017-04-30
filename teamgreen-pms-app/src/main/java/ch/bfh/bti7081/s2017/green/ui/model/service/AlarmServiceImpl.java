package ch.bfh.bti7081.s2017.green.ui.model.service;

import ch.bfh.bti7081.s2017.green.bean.AlarmBean;
import ch.bfh.bti7081.s2017.green.data.AlarmRepository;
import ch.bfh.bti7081.s2017.green.domain.Alarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl extends BaseService<Alarm, AlarmBean, AlarmRepository> implements AlarmService {

    @Autowired
    public AlarmServiceImpl(AlarmRepository repository) {
        super(repository);
    }

    @Override
    protected Class<AlarmBean> getType() {
        return AlarmBean.class;
    }
}
