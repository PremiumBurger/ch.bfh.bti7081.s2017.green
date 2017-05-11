package ch.bfh.bti7081.s2017.green.ui.components.search;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Component to Display a Searchbar
 * Created by joris on 05.05.17.
 * @author schms27
 */
public class SearchViewImpl extends FormLayout implements SearchView {
    private SearchViewListener listener;   //Listener to forward events to AddressViewPresenter
    private Label title;                                            //Label to display the title on the very top

    public SearchViewImpl() {
        final VerticalLayout main = new VerticalLayout();           //contains all the other components
        final HorizontalLayout titleBox = new HorizontalLayout();   //contains the title label
        final HorizontalLayout controlBox = new HorizontalLayout(); //contains the controls for searching
        final TextField searchFor;                                  //Textfield for typing the search phrase
        final Button search;                                        //button to trigger a search

        //Initialize the components
        searchFor = new TextField();
        searchFor.setValue("Search");
        title = new Label("Title");

        //TODO: Set Width of Textfield and Button (currently not working as intended)
        searchFor.setWidth(10, Unit.PIXELS);
        searchFor.setWidth(80, Unit.PERCENTAGE);
        //searchName.setInputPrompt(“Search by keywords”);
        search = new Button("Search");
        search.setWidth(20, Unit.PERCENTAGE);
        search.setIcon(VaadinIcons.SEARCH);
        search.addClickListener(b -> listener.onButtonClick());         //Add listener to button

        //TODO: Find out how to set a custom style/css/theme globally
        search.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        search.setStyleName(ValoTheme.BUTTON_PRIMARY);


        //Add all the created components to the layout
        titleBox.addComponentsAndExpand(title);
        controlBox.addComponentsAndExpand(searchFor, search);
        controlBox.setWidth(100, Unit.PERCENTAGE);
        main.addComponentsAndExpand(titleBox, controlBox);
        addComponent(main);

        setResponsive(true);
    }


    @Override
    public void addListener(SearchViewListener listener) {
        this.listener = listener;
    }

    /**
     * Sets the Title of the Searchview
     * @param title to be set
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }
}
