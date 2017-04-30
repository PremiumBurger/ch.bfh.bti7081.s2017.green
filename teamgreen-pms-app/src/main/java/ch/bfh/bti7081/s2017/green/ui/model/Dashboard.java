package ch.bfh.bti7081.s2017.green.ui.model;

import ch.bfh.bti7081.s2017.green.ui.model.service.AlarmService;
import ch.bfh.bti7081.s2017.green.ui.model.service.AppointmentService;
import ch.bfh.bti7081.s2017.green.ui.model.service.HealthVisitorService;
import ch.bfh.bti7081.s2017.green.ui.model.service.PatientService;

public class Dashboard {

    private HealthVisitorService healthVisitorService;
    private AlarmService alarmService;
    private PatientService patientService;
    private AppointmentService appointmentService;

    public Dashboard(HealthVisitorService healthVisitorService, AlarmService alarmService, PatientService patientService, AppointmentService appointmentService) {
        this.healthVisitorService = healthVisitorService;
        this.alarmService = alarmService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }
}
