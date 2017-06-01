package ch.bfh.bti7081.s2017.green.util.Visitor;

import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;

/**
 * Created by Tobias Joder on 01.06.2017.
 */
public interface Visitable {

    public JournalEntryBean accept(Visitor visitor);
}
