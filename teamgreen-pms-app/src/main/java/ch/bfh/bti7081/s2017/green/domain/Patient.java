package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("patient")
public class Patient extends Person {

    @ManyToMany(mappedBy = "patients")
    private List<HealthVisitor> healthVisitors;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<Alarm> alarms;

    @OneToOne
    @JoinColumn(name = "journalId")
    private Journal journal;

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

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void addAlarm(Alarm alarm) {
        this.alarms.add(alarm);
    }
}
