package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;

/**
 * Created by joris on 05.05.17.
 */
public interface SearchViewListener {

    void onCombobox(PatientBean patientBean);

    void onTextfield(String str);
}
