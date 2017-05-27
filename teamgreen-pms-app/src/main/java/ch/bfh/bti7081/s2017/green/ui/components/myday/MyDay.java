package ch.bfh.bti7081.s2017.green.ui.components.myday;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.service.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Component
public class MyDay {

    private HealthVisitorService healthVisitorService;
    private AlarmService alarmService;
    private PatientService patientService;
    private AppointmentService appointmentService;
    private AddressService addressService;

    public MyDay(HealthVisitorService healthVisitorService, AlarmService alarmService, PatientService patientService, AppointmentService appointmentService, AddressService addressService) {
        this.healthVisitorService = healthVisitorService;
        this.alarmService = alarmService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
        this.addressService = addressService;
    }

    public List<AppointmentBean> getAll(){
        return new ArrayList<AppointmentBean>(appointmentService.getAll());
    }
}
