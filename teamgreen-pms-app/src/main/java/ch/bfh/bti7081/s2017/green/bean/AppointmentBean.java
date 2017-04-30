package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Appointment;

public class AppointmentBean extends EntityBean<Appointment> {

    private HealthVisitorBean healthVisitor;

    private PatientBean patient;

    public HealthVisitorBean getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitorBean healthVisitor) {
        this.healthVisitor = healthVisitor;
    }

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }
}
