package ch.bfh.bti7081.s2017.green.ui.components.myday;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;
import org.vaadin.addons.stackpanel.StackPanel;
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
        //Disable Spacing between Components
        setSpacing(false);

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
      
        // add button bar
        addComponent(buildButtonbar());

        //Add Search to this Vertical Layout
        addComponent(patientSearch);

        //Set Header for all Appointments
        H1Title dashBoardHeader = new H1Title("My Day");

        addComponent(dashBoardHeader);
        for (AppointmentBean appointment : appointments) {
            FormLayout layout = new FormLayout();

            //to Date Label
            Label to = new Label(appointment.getTo().format(format));
            to.setCaption("To");
            to.setIcon(VaadinIcons.CLOCK);

            //Patient Name Label
            Label patientname = new Label(appointment.getPatient().getFullName());
            patientname.setCaption("Name");
            patientname.setIcon(VaadinIcons.USER);

            //Street Name Label
            Label street = new Label(appointment.getPatient().getAddress().getStrasse());
            street.setIcon(VaadinIcons.HOME);
            street.setCaption("Address");

            //PLZ and Town Label
            Label adr = new Label(appointment.getPatient().getAddress().getPlz() + " " + appointment.getPatient().getAddress().getCity());

            //Details Button
            Button details = new Button("Show Details");
            details.setIcon(VaadinIcons.CLIPBOARD_PULSE);

            //CLicklistener for Appointment Details
            details.addClickListener(e -> getUI().getNavigator().navigateTo("patientDetail" + "/" + appointment.getPatient().getId()));

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

            //Add contentPanel to this VerticalLayout
            addComponent(contentPanel);
        }
    }

    private HorizontalLayout buildButtonbar() {

        HorizontalLayout buttonBarLayout = new HorizontalLayout();
        buttonBarLayout.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
        buttonBarLayout.setWidth(100, Unit.PERCENTAGE);
        HorizontalLayout buttons = new HorizontalLayout();
        buttonBarLayout.addComponent(buttons);

        // buttons
        Button create = new Button("Create new Appointment");
        buttons.addComponents(create);

        //listener
        create.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentCreate" + "/" + 1));

        // styles
        create.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        create.setIcon(VaadinIcons.CALENDAR_USER);
        buttonBarLayout.setResponsive(true);

        return buttonBarLayout;
    }
}
