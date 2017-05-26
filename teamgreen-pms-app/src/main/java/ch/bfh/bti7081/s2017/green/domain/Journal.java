package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Journal extends BaseEntity{

    @OneToOne(mappedBy = "journal")
    private Patient patient;

    @OneToMany(mappedBy = "journal")
    private List<JournalEntry> journalEntries;

    private LocalDateTime createdOn;

    public Journal() {
        this.journalEntries = new ArrayList<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addJournalEntry(JournalEntry je) {
        this.journalEntries.add(je);
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
