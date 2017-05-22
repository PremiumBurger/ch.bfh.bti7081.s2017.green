package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.data.HasValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        searchview.init(search.getAll());
    }

    @Override
    public void onClick(PatientBean patientBean) {
        searchview.setSelection(patientBean);
    }
}

