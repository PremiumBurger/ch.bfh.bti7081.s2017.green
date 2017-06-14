package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentStateTypeService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Component
public class AppointmentDetailModel {

    private AppointmentService appointmentService;

    private PatientService patientService;

    private AppointmentStateTypeService appointmentStateTypeService;

    @Autowired
    public AppointmentDetailModel(AppointmentService appointmentService, PatientService patientService, AppointmentStateTypeService appointmentStateTypeService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.appointmentStateTypeService = appointmentStateTypeService;
    }

    /**
     * Returns the Appointment which will be displayed
     * @param appId the appointment id
     * @return the found {@link AppointmentBean} or <code>null</code> if appointment could not be found
     */
    public AppointmentBean getAppointment(long appId) {
        return appointmentService.getOne(appId);
    }

    /**
     * Returns all available patients
     * @return the set of patients
     */
    public Set<PatientBean> getAllPatients() {
        return patientService.getAll();
    }

    /**
     * Returns all available appointment state types
     * @return the set of types
     */
    public Set<AppointmentStateTypeBean> getAllAppointmentStateTypes() {
        return appointmentStateTypeService.getAll();
    }


    /**
     * Getter for
     * @return AppointmentStateTypeBean
     */
    public AppointmentStateTypeBean getAppointmentStateTypeBean(long id) {
        return appointmentStateTypeService.getOne(id);
    }

    /**
     * Persists the {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    public long saveAppointment(AppointmentBean appointmentBean) {
       return appointmentService.save(appointmentBean);
    }

}
