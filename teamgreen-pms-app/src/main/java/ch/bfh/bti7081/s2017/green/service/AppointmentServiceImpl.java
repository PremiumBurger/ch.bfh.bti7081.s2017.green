package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentRepository;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.service.appointmentState.*;
import ch.bfh.bti7081.s2017.green.webservice.GoogleGeocodingWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends BaseService<Appointment, AppointmentBean, AppointmentRepository> implements AppointmentService {

    private GoogleGeocodingWebService googleGeocodingWebService;

    @Autowired
    private AppointmentStateTypeService stateTypeService;

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
     * Overrides save Method from BaseService
     * because the AppointmentState can not be properly mapped
     * @param id of the appointment to look for
     * @return foundBean or null of not found
     */
    public AppointmentBean getOne(long id) {
        AppointmentBean foundBean = super.getOne(id);
        if(foundBean==null) return null;
        AppointmentState appointmentState = new AppointmentStateNew();
        switch(foundBean.getAppointmentStateType().getDescription()) {
            case "CANCELLED":
                appointmentState = new AppointmentStateCancelled();
                break;
            case "CONFIRMED":
                appointmentState = new AppointmentStateConfirmed();
                break;
            case "POSTPONED":
                appointmentState = new AppointmentStatePostponed();
                break;
            case "FINISHED":
                appointmentState = new AppointmentStateFinished();
                break;
        }
        foundBean.getAppointmentStateType().setAppointmentState(appointmentState);
        return  foundBean;
    }

    /**
     * Get the service of the State Type
     * @return stateTypeService
     */
    public AppointmentStateTypeService getStateTypeService() {
        return stateTypeService;
    }

}
