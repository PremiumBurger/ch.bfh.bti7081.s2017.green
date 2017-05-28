package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

@Component
public class JournalViewImpl extends MasterPageImpl implements JournalView {

    private JournalViewListener listener;

    private VerticalLayout layout;
    private Panel panel;
    Accordion accordion = new Accordion();
    JournalBean journal;

    public JournalViewImpl() {
        this.layout = new VerticalLayout();
        this.panel = new Panel("Journal");

        accordion.setHeight(100.0f, Unit.PERCENTAGE);

        this.panel.setContent(accordion);
        this.layout.addComponents(this.panel);
        setViewContent(layout);
    }

    @Override
    public void addListener(JournalViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {
        this.journal = patient.getJournal();

        for(JournalEntryBean entry : journal.getJournalEntries()){
            Label label = new Label(entry.getText(), ContentMode.HTML);
            label.setWidth(100.0f, Unit.PERCENTAGE);

            VerticalLayout layout = new VerticalLayout(label);
            layout.setMargin(true);

            //Todo: Set Style if Important
            //Todo: Add different Types

            if (entry instanceof AppointmentJournalEntryBean){
                accordion.addTab(layout, "Titel + Datum   " + entry.isImportant(), VaadinIcons.CALENDAR);
            }
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
