package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.Patient;

public final class AppointmentBuilder implements RundumSorglosBuilder<AppointmentBuilder> {
    private HealthVisitor healthVisitor;
    private Patient patient;

    private AppointmentBuilder() {
    }

    public static AppointmentBuilder anAppointment() {
        return new AppointmentBuilder();
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
        appointment.setHealthVisitor(healthVisitor);
        appointment.setPatient(patient);
        return appointment;
    }

    @Override
    public AppointmentBuilder rundumSorglos() {
        healthVisitor = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        patient = PatientBuilder.aPatient().rundumSorglos().build();
        return this;
    }
}
