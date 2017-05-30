package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.*;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "journalEntryType", discriminatorType = DiscriminatorType.INTEGER)
public class JournalEntry extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "journalId")
    private Journal journal;

    @Column(nullable = false, updatable = false, insertable = false)
    private int journalEntryType;
    private String text;
    private boolean isImportant;
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private HealthVisitor createdBy;

    public JournalEntry() {
        // empty constructor
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public HealthVisitor getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(HealthVisitor healthVisitor) {
        this.createdBy = healthVisitor;
    }
}
