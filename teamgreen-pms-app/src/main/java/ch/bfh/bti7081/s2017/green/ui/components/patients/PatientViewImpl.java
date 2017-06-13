package ch.bfh.bti7081.s2017.green.ui.components.patients;


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
 * Implementation of PatientView and inherits from the Vaadin Component VerticalLayout
 * Builds the UI for the Patient Overview
 */
@Component
public class PatientViewImpl extends VerticalLayout implements PatientView {

    /**
     * Declaration of Listener, which offers Access to Presenter
     */
    private PatientViewListener listener;

    /**
     * Declaration of Patient Bean List
     */
    private List<PatientBean> patients;

    /**
     * Declaration of PatientSearch
     */
    private ComboBox<PatientBean> patientSearch;

    /**
     * Default Constructor without Arguments
     */
    public PatientViewImpl(){
        //Initializing Patient Search
        patientSearch = new Autocomplete<PatientBean>();
        patientSearch.setWidth("100%");

        //Add Navigation to patientDetail
        patientSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
                patientSearch.setValue(null);
                getUI().getNavigator().navigateTo("patientDetail" + "/" + e.getValue().getId());
            }
        });
    }

    /**
     * @param listener expects the presenter which has PatientViewListener implemented
     * Adds Presenter to the global listener variable
     */
    @Override
    public void addListener(PatientViewListener listener) {
        this.listener = listener;
    }

    /**
     * @param patients List of Patient Beans
     * passes Patients to UI Components and builds a Overview Panel for each Patient
     */
    @Override
    public void init(List<PatientBean> patients) {
        //Disable Spacing between Components on this Vertical Layout
        setSpacing(false);

        //set global Patient Model
        this.patients = patients;

        //Sets Search Data
        patientSearch.setItems(patients);

        //Remove all Components on this Layout
        this.removeAllComponents();

        //add Search Component
        addComponent(patientSearch);

        //Create Header for Patient Overview
        H1Title patientHeader = new H1Title("Patients");

        //Add Header to Layout
        addComponent(patientHeader);

        //Loop which creates Layout for each Patient
        patients.forEach(patient -> {

            //Create Form Layout
            FormLayout formLayout = new FormLayout();

            //Label for First Name
            Label firstName = new Label(patient.getFirstName());
            firstName.setCaption("Vornamen");

            //Label for Last Name
            Label lastName = new Label(patient.getLastName());
            lastName.setCaption("Nachname");

            //Label for Streetname and Number
            Label street = new Label(patient.getAddress().getStrasse());
            street.setCaption("Strasse");

            //Label for PLZ and Town
            Label address = new Label(patient.getAddress().getPlz() + " " + patient.getAddress().getCity());
            address.setCaption("PLZ/Ort");

            //Label for AHV Number
            Label ahv = new Label(patient.getAhvNr());
            ahv.setCaption("ahv Nr.");

            //Patient Details Button
            Button patientDetailsButton = new Button("Details");
            patientDetailsButton.setIcon(VaadinIcons.USER);

            //Navigation to PatientDetailView
            patientDetailsButton.addClickListener(e -> getUI().getNavigator().navigateTo("patientDetail" + "/" + patient.getId()));

            //DisableSpacing and enable Margin on FormLayout
            formLayout.setMargin(true);
            formLayout.setSpacing(false);

            //Add Components to Formlayout
            formLayout.addComponents(firstName, lastName, street,address,ahv,patientDetailsButton);

            //Create Panel for StackPanel
            Panel contentPanel = new Panel();

            //Add formLayout to ContentPanel
            contentPanel.setContent(formLayout);
            contentPanel.setCaption(patient.getFullName());

            //Converts Panel to StackPanel
            StackPanel stackPanel = StackPanel.extend(contentPanel);

            //Collapses all Panels
            stackPanel.close();

            //Add StackPanel to this Vertical Layout
            addComponent(contentPanel);
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
