package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.JournalEntry;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalEntryBean extends EntityBean<JournalEntry>{

    private JournalBean journal;

    @Size(min=1, max=240)
    @NotNull
    private String text;
    private boolean isImportant;
    private LocalDateTime createdOn;
    private HealthVisitorBean createdBy;

    public JournalBean getJournal() {
        return journal;
    }

    public void setJournal(JournalBean journal) {
        this.journal = journal;
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

    public String getCreatedOnFormatedString(){
        return createdOn.format(DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm"));
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public HealthVisitorBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(HealthVisitorBean healthVisitor) {
        this.createdBy = healthVisitor;
    }
}
