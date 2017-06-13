package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import ch.bfh.bti7081.s2017.green.domain.Journal;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JournalBean extends EntityBean<Journal>{
    private PatientBean patient;
    private List<JournalEntryBean> journalEntries;
    private LocalDateTime createdOn;

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<JournalEntryBean> getJournalEntries() {
        return journalEntries;
    }

    public void addJournalEntry(JournalEntryBean journalEntry) {
        this.journalEntries.add(journalEntry);
    }
    public void setJournalEntries(List<JournalEntryBean> journalEntries) {
        this.journalEntries = journalEntries;

    }
}
