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

        //Todo: Add JournalEntryType: Freie Notiz
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
        String param = viewChangeEvent.getParameters();
        listener.getData(Long.valueOf(param).longValue());
    }
}