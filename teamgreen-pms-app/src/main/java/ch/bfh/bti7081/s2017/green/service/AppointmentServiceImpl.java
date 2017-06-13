package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentRepository;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends BaseService<Appointment, AppointmentBean, AppointmentRepository> implements AppointmentService {

    @Autowired
    private AppointmentStateTypeServiceImpl stateTypeService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository repository) {
        super(repository);
    }

    @Override
    protected Class<AppointmentBean> getType() {
        return AppointmentBean.class;
    }

    /**
     * Overrides save Method from BaseService
     * to trigger the state-dependent Events
     * @param appointmentBean to save
     */
    public long save(AppointmentBean appointmentBean) {
        AppointmentBean oldBean = this.getOne(appointmentBean.getId());
        AppointmentStateTypeBean oldAppointmentStateTypeBean = oldBean.getAppointmentStateType();
        AppointmentStateTypeBean newAppointmentStateTypeBean = appointmentBean.getAppointmentStateType();
        if(newAppointmentStateTypeBean != oldAppointmentStateTypeBean){
            newAppointmentStateTypeBean.onStateSet(appointmentBean,this,oldBean);
        }
        return super.save(appointmentBean);
    }

    public void onStateSetToNew(){

    }

    public AppointmentStateTypeServiceImpl getStateTypeService() {
        return stateTypeService;
    }


}
