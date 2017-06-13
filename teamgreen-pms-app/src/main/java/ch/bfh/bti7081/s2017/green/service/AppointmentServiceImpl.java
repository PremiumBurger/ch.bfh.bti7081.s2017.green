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
     * @param appointmentBean
     */
    public long save(AppointmentBean appointmentBean) {
        AppointmentStateTypeBean oldAppointmentStateTypeBean = this.getOne(appointmentBean.getId()).getAppointmentStateType();
        AppointmentStateTypeBean newAppointmentStateTypeBean = appointmentBean.getAppointmentStateType();
        if(newAppointmentStateTypeBean != oldAppointmentStateTypeBean){
            newAppointmentStateTypeBean.onStateSet(appointmentBean);
        }

        return super.save(appointmentBean);
    }

}
