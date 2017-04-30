package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;

@Entity
public class Appointment extends BaseEntity {

    private HealthVisitor healthVisitor;

    private Patient patient;

    public HealthVisitor getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitor = healthVisitor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
