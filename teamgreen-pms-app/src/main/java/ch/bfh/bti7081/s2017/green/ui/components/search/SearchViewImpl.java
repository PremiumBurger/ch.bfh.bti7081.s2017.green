package ch.bfh.bti7081.s2017.green.ui.components.search;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class SearchViewImpl extends FormLayout implements SearchView {
    private List<SearchViewListener> listeners;
    private Label title;

    public SearchViewImpl() {
        //this.listeners = listeners;
        final VerticalLayout main = new VerticalLayout();
        final HorizontalLayout titleBox = new HorizontalLayout();
        final HorizontalLayout controlBox = new HorizontalLayout();
        final TextField searchName;
        final Button search;
        /* Create UI components */
        searchName = new TextField();
        searchName.setValue("Search");
        title = new Label("Title");

        //TODO: Set Width of Textfield and Button
        searchName.setWidth(10, Unit.PIXELS);
        searchName.setWidth(80, Unit.PERCENTAGE);
        //searchName.setInputPrompt(“Search by keywords”);
        search = new Button("Search");
        search.setWidth(20,Unit.PERCENTAGE);
        search.setIcon(VaadinIcons.SEARCH);

        //TODO: Find out how to set a custom style/css/theme
        search.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        search.setStyleName(ValoTheme.BUTTON_PRIMARY);


        /* Add all the created components to the form */
        titleBox.addComponentsAndExpand(title);
        controlBox.addComponentsAndExpand(searchName, search);
        controlBox.setWidth(100, Unit.PERCENTAGE);
        main.addComponentsAndExpand(titleBox, controlBox);
        addComponent(main);

        setResponsive(true);
    }


    @Override
    public void addListener(SearchViewListener viewListener) {
        listeners.add(viewListener);
    }

    public void setTitle(String title){
        this.title.setValue(title);
    }
}
