package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.data.JournalRepository;
import ch.bfh.bti7081.s2017.green.domain.Journal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class JournalServiceImpl extends BaseService<Journal, JournalBean, JournalRepository> implements JournalService {
    @Autowired
    public JournalServiceImpl(JournalRepository repository){
        super (repository);
    }

    @Override
    protected Class<JournalBean> getType(){
        return JournalBean.class;
    }

    @Override
    public Set<JournalEntryBean> getAllJournalEntriesByPatient() {
        return null;
    }

    @Override
    public Set<JournalEntryBean> getJournalEntriesByType() {
        return null;
    }
}
