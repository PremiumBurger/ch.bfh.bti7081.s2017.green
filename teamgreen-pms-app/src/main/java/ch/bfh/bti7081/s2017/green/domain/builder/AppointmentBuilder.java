package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.AppointmentStateType;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.Patient;

import java.time.LocalDateTime;

public final class AppointmentBuilder implements RundumSorglosBuilder<AppointmentBuilder> {
    private LocalDateTime from;
    private LocalDateTime to;
    private HealthVisitor healthVisitor;
    private Patient patient;

    private AppointmentBuilder() {
    }

    public static AppointmentBuilder anAppointment() {
        return new AppointmentBuilder();
    }

    public AppointmentBuilder withFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

    public AppointmentBuilder withTo(LocalDateTime to) {
        this.to = to;
        return this;
    }

    public AppointmentBuilder withHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitor = healthVisitor;
        return this;
    }

    public AppointmentBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Appointment build() {
        Appointment appointment = new Appointment();
        appointment.setFrom(from);
        appointment.setTo(to);
        appointment.setHealthVisitor(healthVisitor);
        appointment.setPatient(patient);
        appointment.setAppointmentStateType(new AppointmentStateType() {
        });
        return appointment;
    }

    @Override
    public AppointmentBuilder rundumSorglos() {
        from = LocalDateTime.now();
        from = LocalDateTime.now().plusHours(2);
        healthVisitor = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        patient = PatientBuilder.aPatient().rundumSorglos().build();
        return this;
    }
}
