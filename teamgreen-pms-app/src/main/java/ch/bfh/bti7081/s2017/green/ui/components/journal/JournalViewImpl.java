package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class JournalViewImpl extends VerticalLayout implements JournalView {

    private JournalViewListener listener;
    private Button newEntry;

    public JournalViewImpl() {

        //Todo: Add JournalEntryType: Freie Notiz
    }

    @Override
    public void addListener(JournalViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {
        removeAllComponents();

        this.newEntry = new Button("New Entry");
        newEntry.setIcon(VaadinIcons.PLUS_CIRCLE);
        newEntry.addClickListener(e -> listener.);

        addComponent(newEntry);
        addComponent(new JournalEntryListComponent(patient.getJournal().getJournalEntries()));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        String param = viewChangeEvent.getParameters();
        listener.getData(Long.valueOf(param).longValue());
    }


}