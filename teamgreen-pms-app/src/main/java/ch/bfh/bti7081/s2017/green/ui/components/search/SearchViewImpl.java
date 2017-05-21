package ch.bfh.bti7081.s2017.green.ui.components.search;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Patient;
import ch.bfh.bti7081.s2017.green.domain.builder.PatientBuilder;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.DataProviderListener;
import com.vaadin.data.provider.Query;
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




    public SearchViewImpl() {
        final HorizontalLayout layout = new HorizontalLayout();

        //get all data and prepare combobox
        search = new ComboBox<>();
        search.setPlaceholder("No Boardi searched");
        search.setItemCaptionGenerator(PatientBean::getFirstName);

        layout.addComponent(search);
        setHeader(layout);
    }


    @Override
    public void addListener(SearchViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(Set<PatientBean> patients) {
        search.setCaption("Search your Boardi");
        search.setPlaceholder("start typing to find your Boardi");
        search.setItems(dummyPatients());
        //search.setItemCaptionGenerator(PatientBean::getFirstName);
        search.setItemCaptionGenerator(PatientBean::getSearchString);
    }

    private List<PatientBean> dummyPatients(){
        Address address1 = new Address();
        address1.setStrasse("Bernstrasse");
        address1.setCity("Thun");
        address1.setCountry("Switzerland");
        address1.setPlz("3006");
        Patient pat1  = PatientBuilder.aPatient().rundumSorglos().build();
        Patient pat2  = PatientBuilder.aPatient().withFirstName("Joris").withLastName("Baiutti").build();
        Patient pat3  = PatientBuilder.aPatient().withFirstName("Tobias").withLastName("Joder").build();
        Patient pat4  = PatientBuilder.aPatient().withFirstName("Tobias").withLastName("Joder").build();
        Patient pat5  = PatientBuilder.aPatient().withFirstName("Mathew").withLastName("Thekkekara").withAddress(address1).build();
        PatientBean patBean1 = new PatientBean();
        PatientBean patBean2 = new PatientBean();
        PatientBean patBean3 = new PatientBean();
        PatientBean patBean4 = new PatientBean();
        PatientBean patBean5 = new PatientBean();
        patBean1.setEntity(pat1);
        patBean2.setEntity(pat2);
        patBean3.setEntity(pat3);
        patBean4.setEntity(pat4);
        patBean5.setEntity(pat5);

        List<PatientBean> patients = new ArrayList<PatientBean>();
        patients.add(patBean1);
        patients.add(patBean2);
        patients.add(patBean3);
        patients.add(patBean4);
        patients.add(patBean5);
        return patients;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
