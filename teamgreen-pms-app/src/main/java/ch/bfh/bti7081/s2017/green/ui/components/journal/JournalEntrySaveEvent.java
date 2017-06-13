package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;
import com.vaadin.ui.Component;

public class JournalEntrySaveEvent extends Component.Event {
    private JournalEntryBean entryBean;

    public JournalEntrySaveEvent(Component source, JournalEntryBean entryBean) {
        super(source);
        this.entryBean = entryBean;

    }

    public <T extends JournalEntryBean> T getEntryBean() {
        return (T) entryBean;
    }
}
