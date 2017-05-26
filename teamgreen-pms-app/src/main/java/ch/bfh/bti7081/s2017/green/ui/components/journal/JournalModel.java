package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.service.JournalService;
import ch.bfh.bti7081.s2017.green.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Component
public class JournalModel {

    private PatientService patientService;

    private JournalService journalService;

    @Autowired
    public JournalModel(JournalService journalService, PatientService patientService) {
        this.journalService = journalService;
        this.patientService = patientService;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<JournalEntryBean> getJournalEntriesByJournalId(long id) {
        JournalBean journal = journalService.getOne(id);
        if (journal != null) {
            return journal.getJournalEntries();
        }
        return new ArrayList<>();
    }

    public PatientBean getPatientById(long patientId) {
        return patientService.getOne(patientId);
    }
}
