package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.domain.JournalEntry;
import ch.bfh.bti7081.s2017.green.domain.Patient;
import ch.bfh.bti7081.s2017.green.domain.Person;

import java.time.LocalDateTime;

/**
 * Created by Tobias Joder on 21.05.2017.
 */
public final class JournalEntryBuilder implements RundumSorglosBuilder {
    private Patient patient;
    private HealthVisitor healthVisitor;
    private int journalEntryType;
    private String text;
    private Person createdBy;  // In BaseEntity verschieben
    private LocalDateTime createdOn;  // In BaseEntity verschieben
    private Person modifiedBy;  // In BaseEntity verschieben
    private LocalDateTime modifiedOn;  // In BaseEntity verschieben
    private boolean isImportant;

    private JournalEntryBuilder() {
    }

    public static JournalEntryBuilder aJournalEntry() {
        return new JournalEntryBuilder();
    }

    public JournalEntryBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public JournalEntryBuilder withHealthVisitor(HealthVisitor healthVisitor) {
        this.healthVisitor = healthVisitor;
        return this;
    }

    public JournalEntryBuilder withJournalEntryType(int journalEntryType) {
        this.journalEntryType = journalEntryType;
        return this;
    }

    public JournalEntryBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public JournalEntryBuilder withCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public JournalEntryBuilder withCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public JournalEntryBuilder withModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public JournalEntryBuilder withModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public JournalEntryBuilder withIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public JournalEntry build() {
        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setPatient(patient);
        journalEntry.setHealthVisitor(healthVisitor);
        journalEntry.setJournalEntryType(journalEntryType);
        journalEntry.setText(text);
        journalEntry.setCreatedBy(createdBy);
        journalEntry.setCreatedOn(createdOn);
        journalEntry.setModifiedBy(modifiedBy);
        journalEntry.setModifiedOn(modifiedOn);
        return journalEntry;
    }

    @Override
    public JournalEntryBuilder rundumSorglos() {
        HealthVisitor hv = HealthVisitorBuilder.aHealthVisitor().rundumSorglos().build();
        patient = PatientBuilder.aPatient().rundumSorglos().build();
        healthVisitor = hv;
        journalEntryType = 0;
        text = "Es geht im gut! Trinkt viel";
        createdBy = hv;
        createdOn = LocalDateTime.now();
        isImportant = true;
        return this;
    }
}
