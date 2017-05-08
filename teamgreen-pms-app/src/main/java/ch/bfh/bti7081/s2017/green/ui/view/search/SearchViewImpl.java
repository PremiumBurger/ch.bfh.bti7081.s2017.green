package ch.bfh.bti7081.s2017.green.ui.view.search;

import com.vaadin.ui.CustomComponent;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class SearchViewImpl extends CustomComponent implements SearchView {
    private List<SearchViewListener> listeners;

    public SearchViewImpl(List<SearchViewListener> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void addListener(SearchViewListener viewListener) {
        listeners.add(viewListener);
    }
}
