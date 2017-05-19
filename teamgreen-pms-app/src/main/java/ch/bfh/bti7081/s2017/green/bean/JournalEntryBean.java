package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.JournalEntry;
import ch.bfh.bti7081.s2017.green.domain.Person;
import java.time.LocalDateTime;

public class JournalEntryBean extends EntityBean<JournalEntry> {

    private PatientBean patient;
    private HealthVisitorBean healthVisitor;
    private int journalEntryType;
    private String text;
    private boolean isImportant;
    private PersonBean createdBy;  // In BaseEntity verschieben
    private LocalDateTime createdOn;  // In BaseEntity verschieben
    private Person modifiedBy;  // In BaseEntity verschieben
    private LocalDateTime modifiedOn;  // In BaseEntity verschieben

    public JournalEntryBean(PatientBean patient, HealthVisitorBean healthVisitor, int journalEntryType, String text, boolean isImportant, PersonBean createdBy, LocalDateTime createdOn, Person modifiedBy, LocalDateTime modifiedOn) {
        this.patient = patient;
        this.healthVisitor = healthVisitor;
        this.journalEntryType = journalEntryType;
        this.text = text;
        this.isImportant = isImportant;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public HealthVisitorBean getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitorBean healthVisitor) {
        this.healthVisitor = healthVisitor;
    }

    public int getJournalEntryType() {
        return journalEntryType;
    }

    public void setJournalEntryType(int journalEntryType) {
        this.journalEntryType = journalEntryType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public PersonBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(PersonBean createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
