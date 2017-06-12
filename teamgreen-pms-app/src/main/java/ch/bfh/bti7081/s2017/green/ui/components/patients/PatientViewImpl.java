package ch.bfh.bti7081.s2017.green.ui.components.patients;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;
import org.vaadin.addons.stackpanel.StackPanel;

import java.util.List;

/**
 * Created by joris on 01.06.17.
 */
@Component
public class PatientViewImpl extends VerticalLayout implements PatientView {
    private PatientViewListener listener;

    private List<PatientBean> patients;
    private ComboBox<PatientBean> patientSearch;

    public PatientViewImpl(){
        patientSearch = new Autocomplete<PatientBean>();
        patientSearch.setWidth("100%");
        patientSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
                patientSearch.setValue(null);
                getUI().getNavigator().navigateTo("Journal" + "/" + e.getValue().getId());
            }
        });




    }

    @Override
    public void addListener(PatientViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(List<PatientBean> patients) {
        setSpacing(false);
        this.patients = patients;
        patientSearch.setItems(patients);

        this.removeAllComponents();
        addComponent(patientSearch);
        H1Title patientHeader = new H1Title("Patients");
        addComponent(patientHeader);

        patients.forEach(patient -> {
            FormLayout formLayout = new FormLayout();
            Label firstName = new Label(patient.getFirstName());
            firstName.setCaption("Vornamen");
            Label lastName = new Label(patient.getLastName());
            lastName.setCaption("Nachname");
            Label street = new Label(patient.getAddress().getStrasse());
            street.setCaption("Strasse");
            Label address = new Label(patient.getAddress().getPlz() + " " + patient.getAddress().getCity());
            address.setCaption("PLZ/Ort");
            Label ahv = new Label(patient.getAhvNr());
            ahv.setCaption("ahv Nr.");

            Grid<HealthVisitorBean> healthVisitorBeanGrid = new Grid<>(HealthVisitorBean.class);

            healthVisitorBeanGrid.setItems(patient.getHealthVisitors());
            healthVisitorBeanGrid.setCaption("HealthVisitors");
            Button journalButton = new Button("Journal");
            journalButton.setIcon(VaadinIcons.CALENDAR);
            journalButton.addClickListener(e -> getUI().getNavigator().navigateTo("Journal" + "/" + patient.getId()));
            formLayout.setMargin(true);
            formLayout.setSpacing(false);
            formLayout.addComponents(firstName, lastName, street,address,ahv,journalButton);
            Panel contentPanel = new Panel();
            contentPanel.setContent(formLayout);
            contentPanel.setCaption(patient.getFullName());
            StackPanel stackPanel = StackPanel.extend(contentPanel);
            stackPanel.close();

            addComponent(contentPanel);

        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
