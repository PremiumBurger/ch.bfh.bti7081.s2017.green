package ch.bfh.bti7081.s2017.green.ui.components.patients;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;

import java.util.List;
import com.vaadin.navigator.View;

/**
 * Created by joris on 01.06.17.
 */
public interface PatientView extends View{
    public void addListener(PatientViewListener listener);
    public void init(List<PatientBean> patients);

}
