package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Alarm;

import javax.persistence.Entity;
import java.time.LocalDateTime;

public class AlarmBean extends EntityBean<Alarm> {

    private String coordinates;

    private LocalDateTime timestamp;

    private HealthVisitorBean healthVisitor;

    private PatientBean patient;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

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
