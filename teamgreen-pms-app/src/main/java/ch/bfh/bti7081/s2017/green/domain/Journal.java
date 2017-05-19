package ch.bfh.bti7081.s2017.green.domain;

import ch.bfh.bti7081.s2017.green.domain.Patient;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Tobias Joder on 16.05.2017.
 */
public class Journal extends BaseEntity{

    //Todo: Annotationen!


    private Patient patient;
    private Set<JournalEntry> journalList;
    private LocalDateTime createdOn;

    public Journal(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<JournalEntry> getJournalList() {
        return journalList;
    }

    public void setJournalList(Set<JournalEntry> journalList) {
        this.journalList = journalList;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
