package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JournalViewImpl extends MasterPageImpl implements JournalView {

    private JournalViewListener listener;

    private VerticalLayout layout;
    private Panel panel;
    private Grid<JournalEntryBean> grid;


    public JournalViewImpl() {
        this.layout = new VerticalLayout();
        this.panel = new Panel("Journal");

        this.grid = new Grid<>(JournalEntryBean.class);
        //grid.setColumnOrder(grid.getColumn("appointmentId"), grid.getColumn("journalId"), grid.getColumn("journalEntryType"), grid.getColumn("journalEntryType"), grid.getColumn("isImportant"));
        grid.getColumn("id").setHidden(true);

        this.layout.addComponents(this.panel, this.grid);
        setViewContent(layout);
    }

    @Override
    public void addListener(JournalViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {
        JournalBean journal = patient.getJournal();
        if (journal.getJournalEntries() != null) {
            this.grid.setItems(journal.getJournalEntries());
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
