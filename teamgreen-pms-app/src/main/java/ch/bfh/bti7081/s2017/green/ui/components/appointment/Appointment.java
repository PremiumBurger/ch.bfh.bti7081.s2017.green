package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 26.05.17.
 */
@Transactional
@Component
public class Appointment {

    private AppointmentService appointmentService;
    private PatientService patientService;

    @Autowired
    public Appointment(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    public AppointmentBean getSelectedAppointment(){
        return appointmentService.getOne(1);
    }
    public List<PatientBean> getAllPatients(){
        return new ArrayList<PatientBean>(patientService.getAll());
    }
}
