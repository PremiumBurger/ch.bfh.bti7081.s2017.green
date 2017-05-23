package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;

import java.util.Set;

/**
 * Created by joris on 05.05.17.
 */
public interface SearchView extends View{

    void addListener(SearchViewListener viewListener);

    void init(Set<PatientBean> patients);

    void setAutoCompleteSuggestion(Set<PatientBean> patientBeans);
}
