package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Alarm;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class AlarmBuilder implements RundumSorglosBuilder {
    private String coordinates;
    private LocalDateTime timestamp;
    private HealthVisitor healthVisitor;
    private Patient patient;

    private AlarmBuilder() {
    }

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder withCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public AlarmBuilder withTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public AlarmBuilder withHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitor = healthVisitor;
        return this;
    }

    public AlarmBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Alarm build() {
        Alarm alarm = new Alarm();
        alarm.setCoordinates(coordinates);
        alarm.setTimestamp(timestamp);
        alarm.setHealthVisitor(healthVisitor);
        alarm.setPatient(patient);
        return alarm;
    }

    @Override
    public AlarmBuilder rundumSorglos() {
        coordinates = "49595 3939 9494";
        timestamp = LocalDateTime.now();
        healthVisitor = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        patient = PatientBuilder.aPatient().rundumSorglos().build();
        return this;
    }
}
