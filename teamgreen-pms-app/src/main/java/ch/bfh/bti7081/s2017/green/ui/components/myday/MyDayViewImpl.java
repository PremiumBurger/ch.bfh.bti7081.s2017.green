package ch.bfh.bti7081.s2017.green.ui.components.myday;
import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.ui.controls.H2Title;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;
import org.vaadin.addons.stackpanel.StackPanel;
import org.yaml.snakeyaml.tokens.ValueToken;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Implementation of MyDayView and inherits from the Vaadin Component VerticalLayout
 * Builds the UI for the MyDay Dashboard
 */
@Component
public class MyDayViewImpl extends VerticalLayout implements MyDayView {

    /**
     * Declares listener which can be used to access presenter
     */
    MyDayViewListener listener;
    /**
     * Declares AppointmentBean List
     * will be available after init Method get's called
     */
    List<AppointmentBean> appointments;

    /**
     * Declares the ComboBox for the PatientSearch
     */
    ComboBox<PatientBean> patientSearch;

    /**
     * Default Constructor initializes UI Components
     */
    public MyDayViewImpl() {
        //Initialize Search
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
     * @param viewListener expects the presenter which has MyDayViewListener implemented
     * Adds Presenter to the global listener variable
     */
    @Override
    public void addListener (MyDayViewListener viewListener) {
        this.listener = viewListener;
    }

    /**
     * @param event ViewChangeEvent from Navigator
     * When Vaadin Navigator calls this View, this method gets called
     * It calls the getData Method on the Presenter
     */
    @Override
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        listener.getData();
    }

    /**
     * @param appointments List of Appointment Beans and List of Patient Beans for the Search
     * passes Appointments to UI Components and builds a Overview Panel for each Appointment
     *
     */
    public void init (List<AppointmentBean> appointments, List<PatientBean> patientBeans) {
        //Set Data for PatientSearch
        patientSearch.setItems(patientBeans);

        //Define DateFormat for all Date Labels
        DateTimeFormatter format = DateTimeFormatter.ofPattern(PmsConstants.SWISS_DATE_FORMAT);

        //Remove all Components
        this.removeAllComponents();
        addComponent(new H1Title("My Day"));

        //Add Search to this Vertical Layout
        addComponent(patientSearch);

        // set title
        HorizontalLayout appTitleBar = new HorizontalLayout();
        appTitleBar.addComponents(new H2Title("My Appointments"), buildCreateButton());
        addComponent(appTitleBar);

        //Set Header for all Appointments
        VerticalLayout appointmentPanels = new VerticalLayout();
        appointmentPanels.setSpacing(false);
        appointmentPanels.setMargin(false);
        addComponent(appointmentPanels);
        for (int i = 0; i < appointments.size(); i++) {
            AppointmentBean appointment = appointments.get(i);
            FormLayout layout = new FormLayout();

            //to Date Label
            Label to = new Label(appointment.getTo().format(format));
            to.setCaption("To");
            to.setIcon(VaadinIcons.CLOCK);

            //Patient Name Label
            Label patientname = new Label(appointment.getPatient().getFullName());
            patientname.setCaption("Patient");
            patientname.setIcon(VaadinIcons.USER);

            //Street Name Label
            AddressBean appAddress = appointment.getAddress();
            Label street = new Label(appAddress.getStrasse());
            street.setIcon(VaadinIcons.HOME);
            street.setCaption("Address");

            //PLZ and Town Label
            Label adr = new Label(appAddress.getPlz() + " " + appAddress.getCity());

            //Details Button
            Button details = new Button("Show Details");
            details.setIcon(VaadinIcons.CLIPBOARD_PULSE);

            //CLicklistener for Appointment Details
            details.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + appointment.getId()));

            //Add Components to Layout
            layout.addComponents(to,patientname,street,adr,details);

            //Create Content Panel
            Panel contentPanel = new Panel(" Appointment from: " + appointment.getFrom().format(format) + " Patient: " + appointment.getPatient().getFullName());
            contentPanel.setContent(layout);
            contentPanel.setIcon(VaadinIcons.CLOCK);

            //Set Layout Styling
            layout.setMargin(true);
            layout.setSpacing(false);

            //Convert contentPanel to StackPanel
            StackPanel stackPanel =  StackPanel.extend(contentPanel);

            // only open first appointment
            if (i != 0) {
                stackPanel.close();
            }

            //Add contentPanel to this VerticalLayout
            appointmentPanels.addComponent(contentPanel);
        }
    }

    private Button buildCreateButton() {
        Button createAppButton = new Button("New");

        //listener
        createAppButton.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentCreate"));

        // styles
        // createAppButton.setWidth(30, Unit.PIXELS);
        createAppButton.setIcon(VaadinIcons.PLUS);
        createAppButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        createAppButton.addStyleName(ValoTheme.BUTTON_SMALL);
        return createAppButton;
    }
}
