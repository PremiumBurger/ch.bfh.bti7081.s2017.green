package ch.bfh.bti7081.s2017.green.ui.view.component.search;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class SearchViewImpl extends FormLayout implements SearchView {
    private List<SearchViewListener> listeners;


    public SearchViewImpl() {
        //this.listeners = listeners;
        final HorizontalLayout header = new HorizontalLayout();
        final TextField searchName;
        final Button search;
        /* Create UI components */
        searchName = new TextField();
        searchName.setValue("Search");
        //searchName.setInputPrompt(“Search by keywords”);
        search = new Button("Search");
        search.setIcon(VaadinIcons.SEARCH);

        /* Add all the created components to the form */
        addComponent(header);
        header.addComponentsAndExpand(searchName,search);

        setResponsive(true);
    }


    @Override
    public void addListener(SearchViewListener viewListener) {
        listeners.add(viewListener);
    }
}
