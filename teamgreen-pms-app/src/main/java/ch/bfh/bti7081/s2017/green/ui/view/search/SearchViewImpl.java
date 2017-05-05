package ch.bfh.bti7081.s2017.green.ui.view.search;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class SearchViewImpl implements SearchView {
    private List<SearchViewListener> listeners;

    public SearchViewImpl(List<SearchViewListener> listeners) {
        this.listeners = listeners;
    }
}
