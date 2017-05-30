package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class JournalViewImpl extends MasterPageImpl implements JournalView {

    private JournalViewListener listener;
    private JournalComponent journalComponent;
    private VerticalLayout layout;

    public JournalViewImpl() {

        //Todo: Add Button to Component
        //Todo: Add JournalEntryType: Freie Notiz
        
        this.layout = new VerticalLayout();

        Button newEntry = new Button("");
        newEntry.setIcon(VaadinIcons.PLUS_CIRCLE);
        //newEntry.addClickListener();

        this.layout.addComponent(newEntry);
        //this.layout.addComponent(popup);

    }

    @Override
    public void addListener(JournalViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {
        this.journalComponent = new JournalComponent(patient);
        this.layout.addComponents(this.journalComponent);
        setViewContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}