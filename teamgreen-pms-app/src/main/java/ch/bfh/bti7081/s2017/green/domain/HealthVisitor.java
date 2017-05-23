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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Alarm> getAlarms() {
        return alarms;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        if (appointment.getHealthVisitor() != this) {
            appointment.setHealthVisitor(this);
        }
    }

    public void addAlarm(Alarm alarm) {
        this.alarms.add(alarm);
        if (alarm.getHealthVisitor() != this) {
            alarm.setHealthVisitor(this);
        }
    }
}
