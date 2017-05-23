package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Journal;
import ch.bfh.bti7081.s2017.green.domain.JournalEntry;
import ch.bfh.bti7081.s2017.green.domain.Person;

import java.time.LocalDateTime;

public class JournalEntryBean extends EntityBean<JournalEntry>{

    private JournalBean journal;

    private String text;
    private boolean isImportant;

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
}
