package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import ch.bfh.bti7081.s2017.green.data.JournalEntryRepository;
import ch.bfh.bti7081.s2017.green.data.JournalRepository;
import ch.bfh.bti7081.s2017.green.domain.Journal;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JournalServiceImpl extends BaseService<Journal, JournalBean, JournalRepository> implements JournalService {
    @Autowired
    public JournalServiceImpl(JournalRepository repository){
        super (repository);
    }

    @Override
    protected Class<JournalBean> getType(){
        return JournalBean.class;
    }

}
