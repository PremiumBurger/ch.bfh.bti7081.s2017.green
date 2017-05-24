package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Patient;
import ch.bfh.bti7081.s2017.green.domain.builder.PatientBuilder;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.DataProviderListener;
import com.vaadin.data.provider.Query;
import com.vaadin.event.selection.SingleSelectionListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteQuery;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestion;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Component to Display a Searchbar
 * Created by joris on 05.05.17.
 * @author schms27
 */
@org.springframework.stereotype.Component
public class SearchViewImpl extends MasterPageImpl implements SearchView {
    private SearchViewListener listener;   //Listener to forward events to AddressViewPresenter

    AutocompleteTextField search ;
    public SearchViewImpl() {
        final HorizontalLayout layout = new HorizontalLayout();
        final VerticalLayout verticalLayout = new VerticalLayout();
        //get all data and prepare combobox
        search = new AutocompleteTextField();

        //set as header
        layout.addComponent(search);
        layout.addComponent(verticalLayout);
        layout.setWidth(100,Unit.PERCENTAGE);
        setHeader(layout);
    }


    @Override
    public void addListener(SearchViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(Set<PatientBean> patients) {
        //combobox search
        search.setCaption("Combobox search");
        search.setWidth("100%");
        search.addValueChangeListener(event-> listener.onAutoComplete(event.toString()));

    }

    @Override
    public void setAutoCompleteSuggestion(Set<PatientBean> patientBeans) {
        Set<AutocompleteSuggestion> set = patientBeans.stream().map(
                pb -> new AutocompleteSuggestion(String.valueOf(pb.getId()),pb.getSearchString())).collect(Collectors.toSet());
        search.setSuggestionProvider(new AutocompleteSuggestionProvider() {
            @Override
            public Collection<AutocompleteSuggestion> querySuggestions(AutocompleteQuery autocompleteQuery) {
                return set;
            }
        });
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
