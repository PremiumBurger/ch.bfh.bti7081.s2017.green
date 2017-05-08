package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

// @Entity
public class HealthVisitor extends Person {

    private List<Patient> patients;

    private List<Appointment> appointments;

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
