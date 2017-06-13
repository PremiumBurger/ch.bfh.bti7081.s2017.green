package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;

import java.util.ArrayList;
import java.util.List;

public class HealthVisitorBean extends PersonBean {

    private List<PatientBean> patients;

    private List<AppointmentBean> appointments;

    private List<AlarmBean> alarms;

    public HealthVisitorBean() {
        setEntity(new HealthVisitor(), false);
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        alarms = new ArrayList<>();
    }


    public List<PatientBean> getPatients() {
        return patients;
    }

    public List<AppointmentBean> getAppointments() {
        return appointments;
    }

    public List<AlarmBean> getAlarms() {
        return alarms;
    }

    public String getName() {return getFirstName()+" "+getLastName();}
}
