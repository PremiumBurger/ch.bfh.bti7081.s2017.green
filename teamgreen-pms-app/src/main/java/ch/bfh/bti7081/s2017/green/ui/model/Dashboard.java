package ch.bfh.bti7081.s2017.green.ui.model;

import ch.bfh.bti7081.s2017.green.service.*;

public class Dashboard {

    private HealthVisitorService healthVisitorService;
    private AlarmService alarmService;
    private PatientService patientService;
    private AppointmentService appointmentService;
    private AddressService addressService;

    public Dashboard(HealthVisitorService healthVisitorService, AlarmService alarmService, PatientService patientService, AppointmentService appointmentService, AddressService addressService) {
        this.healthVisitorService = healthVisitorService;
        this.alarmService = alarmService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
        this.addressService = addressService;
    }
}
