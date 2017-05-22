package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.*;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "journalEntryType", discriminatorType = DiscriminatorType.INTEGER)
public class JournalEntry extends BaseEntity {

    //Todo: Annotationen!

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToMany
    @JoinColumn(name = "healthVisitorId")
    private HealthVisitor healthVisitor;

    private int journalEntryType;
    private String text;
    private boolean isImportant;
    private Person createdBy;  // In BaseEntity verschieben
    private LocalDateTime createdOn;  // In BaseEntity verschieben
    private Person modifiedBy;  // In BaseEntity verschieben
    private LocalDateTime modifiedOn;  // In BaseEntity verschieben

    public JournalEntry() {
    }

    public JournalEntry(Patient patient, HealthVisitor healthVisitor, int journalEntryType, String text, boolean isImportant, Person createdBy, LocalDateTime createdOn, Person modifiedBy, LocalDateTime modifiedOn) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthVisitor getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitor healthVisitor) {
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

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
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
