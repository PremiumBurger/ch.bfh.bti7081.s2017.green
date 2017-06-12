package ch.bfh.bti7081.s2017.green.ui.components.journal;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;

public interface JournalView extends View {
    void addListener(JournalViewListener listener);
    void init(PatientBean patient);
}
