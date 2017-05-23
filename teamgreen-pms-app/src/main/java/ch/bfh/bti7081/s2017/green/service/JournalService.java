package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.JournalBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;

import java.util.Set;

public interface JournalService extends BaseServiceInterface<JournalBean> {

    Set<JournalEntryBean> getAllJournalEntriesByPatient();

    Set<JournalEntryBean> getJournalEntriesByType();

}
