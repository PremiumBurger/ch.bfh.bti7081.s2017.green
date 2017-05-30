package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("healthvisitor")
public class HealthVisitor extends Person {

    @ManyToMany
    @JoinTable(
            name = "PatientHealthVisitor",
            joinColumns = @JoinColumn(name = "healthVisitorId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patientId", referencedColumnName = "id"))
    private List<Patient> patients;
    @Transient
    @OneToMany(mappedBy = "healthVisitor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "healthVisitor")
    private List<Alarm> alarms;

    public HealthVisitor() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        alarms = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Alarm> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
    }
}
