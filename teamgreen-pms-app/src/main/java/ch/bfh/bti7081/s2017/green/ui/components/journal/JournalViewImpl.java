package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import java.time.LocalDateTime;

public class JournalViewImpl extends MasterPageImpl implements View {

    private JournalViewListener listener;
    private VerticalLayout layout;
    private VerticalLayout containerForEntries;
    private Panel panel;


    public JournalViewImpl() {
        this.layout = new VerticalLayout();
        this.containerForEntries = new VerticalLayout();
        this.panel = new Panel("Journal");

        this.layout.addComponents(this.panel, this.containerForEntries);
        addJournalEntries();
        setViewContent(layout);
    }

    private void addJournalEntries(){
        //Set entries = this.listener.getJournalEntries();
        //forEach(JournalEntryBean in entries){
            containerForEntries.addComponent(new JournalEntryComponent(LocalDateTime.now(),"Test",true, "Appointment"));
            containerForEntries.addComponent(new JournalEntryComponent(LocalDateTime.now(),"Test",true, "Appointment"));
            containerForEntries.addComponent(new JournalEntryComponent(LocalDateTime.now(),"Test",true, "Appointment"));
        //}
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}