package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.*;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "journalEntryType", discriminatorType = DiscriminatorType.INTEGER)
public abstract class JournalEntry extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "journalId")
    private Journal journal;

    @Column(nullable = false, updatable = false, insertable = false)
    private int journalEntryType;
    private String text;
    private boolean isImportant;

    public JournalEntry() {
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

}
