package ch.bfh.bti7081.s2017.green.ui.components.patients;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import java.util.List;
import com.vaadin.navigator.View;

/**
 * Inherits from Vaadin Navigator View and defines which methods are available on the View Implementation
 */
public interface PatientView extends View{
    public void addListener(PatientViewListener listener);
    public void init(List<PatientBean> patients);

}
