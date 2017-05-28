package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Appointment;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentBean extends EntityBean<Appointment> {


    private LocalDateTime from;

    private LocalDateTime to;

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

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
