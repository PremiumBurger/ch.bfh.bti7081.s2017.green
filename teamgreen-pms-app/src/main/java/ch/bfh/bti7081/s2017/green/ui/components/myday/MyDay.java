package ch.bfh.bti7081.s2017.green.ui.components.myday;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * UI Model fo the myDaydataStructure
 */
@Transactional
@Component
public class MyDay {

    /**
     * Declares appointmentService
     */
    private AppointmentService appointmentService;

    /**
     * Declares patientService
     */
    private PatientService patientService;

    /**
     * @param appointmentService Initializes appointmentservice and patientservice
     */
    public MyDay(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    /**
     * @return returns a List of Appointmentbeans as a List
     * AppointmentService delivers Appointmentbeans
     */
    public List<AppointmentBean> getAllAppointments(){
        return new ArrayList<AppointmentBean>(appointmentService.getAll());
    }

    /**
     * @return returns a List of Patientbeans as a List
     * PatientService delivers Patientbeans
     */
    public List<PatientBean> getAllPatients(){
        return new ArrayList<PatientBean>(patientService.getAll());
    }


    /**
     * Getter for
     * @return AppointmentStateTypeBean
     */
    public AppointmentStateTypeBean getAppointmentStateTypeBean(long id) {
        return appointmentService.getStateTypeService().getOne(id);
    }
}
