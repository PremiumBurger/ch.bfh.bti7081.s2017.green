package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.AppointmentStateTypeService;
import ch.bfh.bti7081.s2017.green.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;


@Transactional
@Component
public class AppointmentCreateModel {

    private AppointmentService appointmentService;

    private PatientService patientService;

    private AppointmentStateTypeService appointmentStateTypeService;

    private HealthVisitorService healthVisitorService;

    @Autowired
    public AppointmentCreateModel(AppointmentService appointmentService, PatientService patientService, AppointmentStateTypeService appointmentStateTypeService, HealthVisitorService healthVisitorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.appointmentStateTypeService = appointmentStateTypeService;
        this.healthVisitorService = healthVisitorService;
    }


    /**
     * Returns the Appointment which will be displayed
     *
     * @param appId the appointment id
     * @return the found {@link AppointmentBean} or <code>null</code> if appointment could not be found
     */
    public AppointmentBean getAppointment(long appId) {
        return appointmentService.getOne(appId);
    }

    /**
     * Returns all available patients
     *
     * @return the set of patients
     */
    public Set<PatientBean> getAllPatients() {
        return patientService.getAll();
    }

    /**
     * Returns all available appointment state types
     *
     * @return the set of types
     */
    public Set<AppointmentStateTypeBean> getAllAppointmentStateTypes() {
        return appointmentStateTypeService.getAll();
    }

    /**
     * Persists the {@link AppointmentBean}
     *
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    public void saveAppointment(AppointmentBean appointmentBean) {
        if(validateAppointment(appointmentBean)) {
            long savedAppointmentId = appointmentService.save(appointmentBean);
            if (savedAppointmentId > 0) {
                Notification notif = new Notification(
                        "Appointment # " + savedAppointmentId + " has been saved successfully"
                );
                notif.setDelayMsec(5000);
                notif.setPosition(Position.BOTTOM_CENTER);
                notif.show(Page.getCurrent());
            }
        }
    }

    /**
     * Returns the HealthVisitor for the given Id
     *
     * @param healthVisitorId
     * @return the found {@link HealthVisitorBean} or <code>null</code> if healthVisitorBean could not be found
     */
    public HealthVisitorBean getHealthVisitor(long healthVisitorId) {
        return healthVisitorService.getOne(healthVisitorId);
    }

    /**
     * Returns the AppointmentStateTypeBean for the given Id
     *
     * @param appointmentStateTypeId
     * @return the found {@link AppointmentStateTypeBean} or <code>null</code> if AppointmentStateTypeBean could not be found
     */
    public AppointmentStateTypeBean getAppointmentStateType(long appointmentStateTypeId) {
        return appointmentStateTypeService.getOne(appointmentStateTypeId);
    }

    private boolean validateAppointment(AppointmentBean appointmentBean) {
        long hvId;
        long patientId;
        AppointmentStateTypeBean appointmentState;
        LocalDateTime from;
        LocalDateTime to;
        ArrayList<String> errors = new ArrayList<>();
        try {
            hvId = appointmentBean.getHealthVisitor().getId();
        }catch(NullPointerException e){
            hvId = 0;
        }
        try {
            patientId = appointmentBean.getPatient().getId();
        }catch(NullPointerException e){
            patientId = 0;
        }
        appointmentState = appointmentBean.getAppointmentStateType();
        try {
            from = appointmentBean.getFrom();
            if(from == null)from = LocalDateTime.MIN;
        }catch(NullPointerException e){
            from = LocalDateTime.MIN;
        }
        try {
            to = appointmentBean.getTo();
            if(to == null)to = LocalDateTime.MIN;
        }catch(NullPointerException e){
            to = LocalDateTime.MIN;
        }

        if (hvId <= 0)errors.add("Health Visitor not set");
        if (patientId <= 0)errors.add("Patient not set");
        if (appointmentState == null)errors.add("State not set");
        if(from.equals(LocalDateTime.MIN))errors.add("From can not be empty");
        if(to.equals(LocalDateTime.MIN))errors.add("To can not be empty");
        if(to.isBefore(from))errors.add("To can not be earlier than From");

        //get all validation errors, notify user
        if(!errors.isEmpty()){
            StringBuilder error = new StringBuilder();
            for(String string : errors) {
                error.append(string);
                error.append(", ");
            }
            Notification errorNotif = new Notification(
                    "Warning",
                    error.substring(0, error.length() - 1) + " Appointment has not been saved",
                    Notification.TYPE_ERROR_MESSAGE);
            errorNotif.setDelayMsec(10000);
            errorNotif.setPosition(Position.BOTTOM_CENTER);
            errorNotif.show(Page.getCurrent());
            return false;
        }
        return true;
    }
}