package ch.bfh.bti7081.s2017.green.ui.view.component.search;

import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class SearchViewImpl extends FormLayout implements SearchView {
    private List<SearchViewListener> listeners;
    private TextField tf;
    private NativeSelect fieldToSearch;
    private CheckBox saveSearch;
    private TextField searchName;


    public SearchViewImpl() {
        //this.listeners = listeners;
        final VerticalLayout header = new VerticalLayout(new Label("Header"));

        /* Create UI components */
        tf = new TextField("Search term");
        fieldToSearch = new NativeSelect("Field to search");
        saveSearch = new CheckBox("Save search");
        searchName = new TextField("Search name");
        Button search = new Button("Search");

        /* Add all the created components to the form */
        header.addComponent(tf);
        addComponent(fieldToSearch);
        addComponent(saveSearch);
        addComponent(searchName);
        addComponent(search);
    }


    @Override
    public void addListener(SearchViewListener viewListener) {
        listeners.add(viewListener);
    }
}
