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
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * Component to Display a Searchbar
 * Created by joris on 05.05.17.
 * @author schms27
 */
@org.springframework.stereotype.Component
public class SearchViewImpl extends MasterPageImpl implements SearchView {
    private SearchViewListener listener;   //Listener to forward events to AddressViewPresenter

    ComboBox<PatientBean> search;

    TextField textField;
    Label searchLabel;

    public SearchViewImpl() {
        final HorizontalLayout layout = new HorizontalLayout();
        final VerticalLayout verticalLayout = new VerticalLayout();
        //get all data and prepare combobox
        search = new ComboBox<>();

        //set all data for the TextField Search
        textField = new TextField();
        searchLabel = new Label();
        verticalLayout.addComponent(searchLabel);
        verticalLayout.addComponent(textField);
        verticalLayout.setWidth(100,Unit.PERCENTAGE);

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
        search.setPlaceholder("start typing to find your Boardi");
        search.setItems(patients);
        search.setItemCaptionGenerator(PatientBean::getSearchString);
        search.setPopupWidth("100%");
        search.setWidth("100%");
        search.addValueChangeListener(event -> listener.onCombobox(event.getValue()));

        //textField Search
        searchLabel.setValue("Textfield Search");
        textField.setPlaceholder("Start typing to search directly in database");
        textField.addValueChangeListener(event -> listener.onTextfield(event.getValue()));
    }

    @Override
    public void setComboboxSelection(PatientBean patientBean) {
        Notification.show("The selected Patient is"+patientBean.getId()+" With name: "+patientBean.getFirstName(),
                Notification.Type.HUMANIZED_MESSAGE);
    }

    @Override
    public void setTextfieldSelection(Set<PatientBean> patientBeans) {
        Notification.show("The search result is: "+patientBeans.toString(),
                Notification.Type.HUMANIZED_MESSAGE);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
