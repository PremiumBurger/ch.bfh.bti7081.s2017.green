package ch.bfh.bti7081.s2017.green.ui.components.search;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Handles the interaction between View and Model
 * @author schms27
 */
public class SearchPresenter implements SearchViewListener {
    private SearchView searchview;          //View
    private Search search;                  //Model

    @Autowired
    public SearchPresenter(SearchView searchview, Search search) {
        this.searchview = searchview;
        this.search = search;
        searchview.addListener(this);
    }

    @Override
    public void onButtonClick() {
        //TODO: Implement Search function
    }
}

