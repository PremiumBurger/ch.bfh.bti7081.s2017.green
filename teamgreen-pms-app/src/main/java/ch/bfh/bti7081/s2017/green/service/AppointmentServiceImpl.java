package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.data.AppointmentRepository;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.webservice.GoogleGeocodingWebService;
import ch.bfh.bti7081.s2017.green.webservice.dto.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends BaseService<Appointment, AppointmentBean, AppointmentRepository> implements AppointmentService {

    private GoogleGeocodingWebService googleGeocodingWebService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository repository, GoogleGeocodingWebService googleGeocodingWebService) {
        super(repository);
        this.googleGeocodingWebService = googleGeocodingWebService;


        Address addr = new Address();
        addr.setStrasse("Metzgergasse 1");
        addr.setPlz("3400");
        addr.setCity("Burgdorf");

        Geometry coordinatesByAddress = googleGeocodingWebService.getCoordinatesByAddress(addr);

        String test = "";


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
            AppointmentStateTypeBean oldAppointmentStateTypeBean = this.getOne(appointmentBean.getId()).getAppointmentStateType();
            AppointmentStateTypeBean newAppointmentStateTypeBean = appointmentBean.getAppointmentStateType();
            if (!newAppointmentStateTypeBean.getDescription().equals(oldAppointmentStateTypeBean.getDescription())) {
                newAppointmentStateTypeBean.onStateSet(appointmentBean);
            }
        }
        return super.save(appointmentBean);
    }

}
