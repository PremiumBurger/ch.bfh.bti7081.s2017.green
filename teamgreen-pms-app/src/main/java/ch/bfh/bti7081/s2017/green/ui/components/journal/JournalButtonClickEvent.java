package ch.bfh.bti7081.s2017.green.ui.components.journal;

import com.vaadin.ui.Component;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

@FunctionalInterface
public interface JournalButtonClickEvent{
    Method BUTTON_CLICK_METHOD = ReflectTools.findMethod(JournalButtonClickEvent.class, "addJournalEntryClick", new Class[]{Component.Event.class});
    void addJournalEntryClick(Component.Event event);
}
