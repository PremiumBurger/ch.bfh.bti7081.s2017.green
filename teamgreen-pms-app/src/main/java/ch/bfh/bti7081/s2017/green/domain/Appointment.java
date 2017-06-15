package ch.bfh.bti7081.s2017.green.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Set;

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
    @Cascade(CascadeType.MERGE)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "addressId")
    @Cascade(CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "appointment")

    private Set<AppointmentJournalEntry> journalEntries;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
