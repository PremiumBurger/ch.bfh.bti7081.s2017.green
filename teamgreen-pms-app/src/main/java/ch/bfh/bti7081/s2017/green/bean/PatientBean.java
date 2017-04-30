package ch.bfh.bti7081.s2017.green.bean;

import java.util.ArrayList;
import java.util.List;

public class PatientBean extends PersonBean {

    private List<HealthVisitorBean> healthVisitors;

    private List<AppointmentBean> appointments;

    private List<AlarmBean> alarms;


    public PatientBean() {
        healthVisitors = new ArrayList<>();
        appointments = new ArrayList<>();
        alarms = new ArrayList<>();
    }

    public List<HealthVisitorBean> getHealthVisitors() {
        return healthVisitors;
    }

    public List<AppointmentBean> getAppointments() {
        return appointments;
    }

    public List<AlarmBean> getAlarms() {
        return alarms;
    }
}
