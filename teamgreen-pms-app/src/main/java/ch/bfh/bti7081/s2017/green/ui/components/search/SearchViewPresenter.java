package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Handles the interaction between View and Model
 * @author schms27
 */
@Component
public class SearchViewPresenter implements SearchViewListener {
    private SearchView searchview;          //View
    private Search search;                  //Model

    @Autowired
    public SearchViewPresenter(SearchView searchview, Search search) {
        this.searchview = searchview;
        this.search = search;
        searchview.addListener(this);
        searchview.init(this.search.getAll());
    }

    @Override
    public void onCombobox(PatientBean patientBean) {
        searchview.setComboboxSelection(patientBean);
    }

    @Override
    public void onTextfield(String str) {
        String[] searchStrings= str.split("\\s");
        List<String> al = Arrays.asList(searchStrings);
        Set test = search.getTyping(al);
        searchview.setTextfieldSelection(test);
    }
}

