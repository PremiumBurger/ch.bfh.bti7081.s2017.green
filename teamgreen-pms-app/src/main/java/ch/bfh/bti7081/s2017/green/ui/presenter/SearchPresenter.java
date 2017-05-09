package ch.bfh.bti7081.s2017.green.ui.presenter;

import ch.bfh.bti7081.s2017.green.ui.model.Search;
import ch.bfh.bti7081.s2017.green.ui.view.component.search.SearchView;
import ch.bfh.bti7081.s2017.green.ui.view.component.search.SearchViewListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by S.Schmid on 08.05.2017.
 */
public class SearchPresenter implements SearchViewListener {

    //View
    private SearchView searchview;
    //Model
    private Search search;

    @Autowired
    public SearchPresenter(SearchView searchview, Search search) {
        this.searchview = searchview;
        this.search = search;
        searchview.addListener(this);
    }
}

