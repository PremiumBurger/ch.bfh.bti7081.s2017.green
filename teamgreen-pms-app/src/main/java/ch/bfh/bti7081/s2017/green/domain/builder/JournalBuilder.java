package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.AppointmentJournalEntry;
import ch.bfh.bti7081.s2017.green.domain.Journal;
import ch.bfh.bti7081.s2017.green.domain.Patient;

import java.time.LocalDateTime;

/**
 * Created by Tobias Joder on 21.05.2017.
 */
public final class JournalBuilder implements RundumSorglosBuilder {
    private Patient patient;
    private LocalDateTime createdOn;

    private JournalBuilder() {
    }

    public static JournalBuilder aJournal() {
        return new JournalBuilder();
    }

    public JournalBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public JournalBuilder withCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Journal build() {
        Journal journal = new Journal();
        journal.setPatient(patient);
        journal.setCreatedOn(createdOn);
        return journal;
    }

    @Override
    public JournalBuilder rundumSorglos() {
        Journal j = new Journal();
        j.setCreatedOn(LocalDateTime.now());
        j.addJournalEntry(AppointmentJournalEntryBuilder.anAppointmentJournalEntry().build());
        return this;
    }
}
