package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import java.time.LocalDateTime;
import java.util.Set;

public class JournalBean extends BaseEntity{
    private PatientBean patient;
    private Set<JournalEntryBean> journalList;
    private LocalDateTime createdOn;

    public JournalBean(PatientBean patient, Set<JournalEntryBean> journalList, LocalDateTime createdOn) {
        this.patient = patient;
        this.journalList = journalList;
        this.createdOn = createdOn;
    }

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public Set<JournalEntryBean> getJournalList() {
        return journalList;
    }

    public void setJournalList(Set<JournalEntryBean> journalList) {
        this.journalList = journalList;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
