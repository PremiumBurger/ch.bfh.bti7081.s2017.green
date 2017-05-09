package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HealthVisitor extends Person {

    @ManyToMany
    private List<Patient> patients;

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
}
