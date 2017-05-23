package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Journal extends BaseEntity{

    @OneToOne
    private Patient patient;

    @OneToMany(mappedBy = "journal")
    private Set<JournalEntry> journals;
    private LocalDateTime createdOn;

    public Journal() {
        this.journals = new HashSet<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addJournalEntry(JournalEntry je) {
        this.journals.add(je);
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
