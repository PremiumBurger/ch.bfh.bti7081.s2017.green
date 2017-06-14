package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentRepository;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.webservice.GoogleGeocodingWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends BaseService<Appointment, AppointmentBean, AppointmentRepository> implements AppointmentService {

    private GoogleGeocodingWebService googleGeocodingWebService;

    @Autowired
    private AppointmentStateTypeServiceImpl stateTypeService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository repository, GoogleGeocodingWebService googleGeocodingWebService) {
        super(repository);
        this.googleGeocodingWebService = googleGeocodingWebService;
    }

    @Override
    protected Class<AppointmentBean> getType() {
        return AppointmentBean.class;
    }

    /**
     * Overrides save Method from BaseService
     * to trigger the state-dependent Events
     * @param appointmentBean the Appointment Bean to save
     */
    public long save(AppointmentBean appointmentBean) {
        if(appointmentBean.getId()>0) {
            AppointmentBean oldBean = this.getOne(appointmentBean.getId());
            AppointmentStateTypeBean oldAppointmentStateTypeBean = oldBean.getAppointmentStateType();
            AppointmentStateTypeBean newAppointmentStateTypeBean = appointmentBean.getAppointmentStateType();
            if (newAppointmentStateTypeBean != oldAppointmentStateTypeBean) {
                newAppointmentStateTypeBean.getAppointmentState().onStateSet(appointmentBean, this, oldBean);
            }
        }

        return super.save(appointmentBean);
    }

    /**
     * Get the service of the State Type
     * @return stateTypeService
     */
    public AppointmentStateTypeServiceImpl getStateTypeService() {
        return stateTypeService;
    }

}
