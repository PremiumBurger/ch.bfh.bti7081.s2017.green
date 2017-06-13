package ch.bfh.bti7081.s2017.green.ui.components.journal;

import com.vaadin.ui.Component;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

@FunctionalInterface
public interface JournalEntrySaveButtonClickEvent {
    Method BUTTON_CLICK_METHOD = ReflectTools.findMethod(JournalEntrySaveButtonClickEvent.class, "addSaveJournalEntryListener", new Class[]{JournalEntrySaveEvent.class});
    void addSaveJournalEntryListener(JournalEntrySaveEvent event);
}