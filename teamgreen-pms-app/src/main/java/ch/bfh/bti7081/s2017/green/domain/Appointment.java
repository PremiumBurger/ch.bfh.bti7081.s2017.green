package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Appointment extends BaseEntity {

    @Column(name="[from]")
    private LocalDateTime from;

    @Column(name="[to]")
    private LocalDateTime to;

    @ManyToOne
    @JoinColumn(name = "appointmentStateTypeId")
    private AppointmentStateType appointmentStateType;

    @ManyToOne
    @JoinColumn(name = "healthVisitorId")
    private HealthVisitor healthVisitor;

    @ManyToOne
    @JoinColumn(name = "patientId")
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

    public AppointmentStateType getAppointmentStateType() {
        return appointmentStateType;
    }

    public void setAppointmentStateType(AppointmentStateType appointmentStateType) {
        this.appointmentStateType = appointmentStateType;
    }
}
