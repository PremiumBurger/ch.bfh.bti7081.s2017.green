package ch.bfh.bti7081.s2017.green.domain;

import ch.bfh.bti7081.s2017.green.domain.Patient;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.assertj.core.util.Sets;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Tobias Joder on 16.05.2017.
 */
public class Journal extends BaseEntity{

    //Todo: Annotationen!

    private Patient patient;
    private Set<JournalEntry> journalList;
    private LocalDateTime createdOn;

    public Journal() {
        this.journalList = new HashSet<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addJournalEntry(JournalEntry je) {
        this.journalList.add(je);
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
