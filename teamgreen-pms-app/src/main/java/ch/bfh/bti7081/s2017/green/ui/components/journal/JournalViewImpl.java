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

    public JournalViewImpl() {

        //Todo: Add Button to Component
        //Todo: Add JournalEntryType: Freie Notiz

        Button newEntry = new Button("");
        newEntry.setIcon(VaadinIcons.PLUS_CIRCLE);
        //newEntry.addClickListener();

        addComponent(newEntry);
        //this.layout.addComponent(popup);

    }

    @Override
    public void addListener(JournalViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {
        addComponents(new JournalComponent(patient));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}