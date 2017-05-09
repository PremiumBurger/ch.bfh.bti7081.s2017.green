package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient extends Person {

    @ManyToMany
    private List<HealthVisitor> healthVisitors;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
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
