package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentStateTypeRepository;
import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentStateTypeServiceImpl extends BaseService<AppointmentStateType, AppointmentStateTypeBean, AppointmentStateTypeRepository> implements AppointmentStateTypeService {

    @Autowired
    public AppointmentStateTypeServiceImpl(AppointmentStateTypeRepository repository) {
        super(repository);
    }

    @Override
    protected Class<AppointmentStateTypeBean> getType() {
        return AppointmentStateTypeBean.class;
    }
}
