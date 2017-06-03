package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
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

    @Autowired
    public AppointmentDetailModel(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
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
     * Persists the {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    public void saveAppointment(AppointmentBean appointmentBean) {
        appointmentService.save(appointmentBean);
    }
}
