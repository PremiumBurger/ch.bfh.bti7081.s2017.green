package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import java.time.LocalDateTime;

// @Entity
public class Alarm extends BaseEntity {

    private String coordinates;

    private LocalDateTime timestamp;

    private HealthVisitor healthVisitor;

    private Patient patient;

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
