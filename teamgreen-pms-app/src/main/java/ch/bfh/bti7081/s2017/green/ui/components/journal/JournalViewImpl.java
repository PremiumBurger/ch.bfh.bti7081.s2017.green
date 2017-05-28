package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.JournalEntry;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.Binder;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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
            label.setStyleName("xxx");

            VerticalLayout layout = new VerticalLayout();
            layout.setMargin(true);

            accordion.addTab(label, "Titel + Datum   " + entry.isImportant());
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
