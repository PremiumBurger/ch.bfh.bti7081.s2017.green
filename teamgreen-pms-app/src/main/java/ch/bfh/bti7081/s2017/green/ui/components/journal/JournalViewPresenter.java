package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalViewPresenter implements JournalViewListener {

    private JournalModel journalModel;
    private JournalView journalView;

    @Autowired
    public JournalViewPresenter(JournalView journalView, JournalModel journalModel) {
        this.journalModel = journalModel;
        this.journalView = journalView;
        journalView.addListener(this);

    }

    @Override
    public void getData(long id) {
        journalView.init(journalModel.getPatientById(id));
    }
}
