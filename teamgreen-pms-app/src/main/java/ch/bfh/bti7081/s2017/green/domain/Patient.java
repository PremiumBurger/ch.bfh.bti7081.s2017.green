package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

// @Entity
public class Patient extends Person {

    private List<HealthVisitor> healthVisitors;

    private List<Appointment> appointments;

    private List<Alarm> alarms;


    public Patient() {
        healthVisitors = new ArrayList<>();
        appointments = new ArrayList<>();
        alarms = new ArrayList<>();
    }

    public List<HealthVisitor> getHealthVisitors() {
        return healthVisitors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Alarm> getAlarms() {
        return alarms;
    }
}
