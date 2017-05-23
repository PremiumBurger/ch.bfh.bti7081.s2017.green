package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.*;

import java.time.LocalDateTime;

/**
 * Created by Tobias Joder on 22.05.2017.
 */
public final class AppointmentJournalEntryBuilder implements RundumSorglosBuilder<AppointmentJournalEntryBuilder> {

    private Appointment appointment;
    private int journalEntryType;
    private String text;
    private boolean isImportant;
    private Person createdBy;  // In BaseEntity verschieben
    private LocalDateTime createdOn;  // In BaseEntity verschieben
    private Person modifiedBy;  // In BaseEntity verschieben
    private LocalDateTime modifiedOn;  // In BaseEntity verschieben

    private AppointmentJournalEntryBuilder() {
    }

    public static AppointmentJournalEntryBuilder anAppointmentJournalEntry() {
        return new AppointmentJournalEntryBuilder();
    }

    public AppointmentJournalEntryBuilder withAppointment(Appointment appointment) {
        this.appointment = appointment;
        return this;
    }

    public AppointmentJournalEntryBuilder withJournalEntryType(int journalEntryType) {
        this.journalEntryType = journalEntryType;
        return this;
    }

    public AppointmentJournalEntryBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public AppointmentJournalEntryBuilder withCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AppointmentJournalEntryBuilder withCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public AppointmentJournalEntryBuilder withModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public AppointmentJournalEntryBuilder withModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public AppointmentJournalEntryBuilder withIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public AppointmentJournalEntry build() {
        AppointmentJournalEntry appointmentJournalEntry = new AppointmentJournalEntry();
        appointmentJournalEntry.setAppointment(appointment);
        appointmentJournalEntry.setJournalEntryType(journalEntryType);
        appointmentJournalEntry.setText(text);
        appointmentJournalEntry.setImportant(isImportant);
        return appointmentJournalEntry;
    }

    @Override
    public AppointmentJournalEntryBuilder rundumSorglos() {
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        journalEntryType = 0;
        text = "Es geht im gut! Trinkt viel";
        createdBy = hv;
        createdOn = LocalDateTime.now();
        isImportant = true;
        return this;
    }
}
