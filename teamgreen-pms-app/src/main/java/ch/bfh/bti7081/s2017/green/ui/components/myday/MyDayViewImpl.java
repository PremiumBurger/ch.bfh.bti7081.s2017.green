package ch.bfh.bti7081.s2017.green.ui.components.myday;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
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
    ComboBox<AppointmentBean> appointmentSearch;

    /**
     * Default Constructor initializes UI Components
     */
    public MyDayViewImpl() {
        setSpacing(false);
        appointmentSearch = new Autocomplete<AppointmentBean>();
        appointmentSearch.setWidth("100%");
        appointmentSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
            appointmentSearch.setValue(null);
            getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + e.getValue().getId());
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
     * @param appointments List of Appointment Beans
     * passes Appointments to UI Components and builds a Overview Panel for each Appointment
     *
     */
    public void init (List<AppointmentBean> appointments) {
        appointmentSearch.setItems(appointments);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(PmsConstants.SWISS_DATE_FORMAT);
        this.removeAllComponents();
        addComponent(appointmentSearch);
        H1Title dashBoardHeader = new H1Title("My Day");

        addComponent(dashBoardHeader);
        for (AppointmentBean appointment : appointments) {
            FormLayout layout = new FormLayout();
            layout.setId(String.valueOf(appointment.getId()));
            Label to = new Label(appointment.getTo().format(format));
            to.setCaption("To");
            to.setIcon(VaadinIcons.CLOCK);
            Label patientname = new Label(appointment.getPatient().getFullName());
            patientname.setCaption("Name");
            patientname.setIcon(VaadinIcons.USER);
            Label street = new Label(appointment.getPatient().getAddress().getStrasse());
            street.setIcon(VaadinIcons.HOME);
            street.setCaption("Address");
            Label adr = new Label(appointment.getPatient().getAddress().getPlz() + " " + appointment.getPatient().getAddress().getCity());
            Button details = new Button("Show Details");
            details.setIcon(VaadinIcons.CLIPBOARD_PULSE);
            details.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + appointment.getId()));
            layout.addComponents(to,patientname,street,adr,details);
            Panel contentPanel = new Panel(" Appointment from: " + appointment.getFrom().format(format) + " Patient: " + appointment.getPatient().getFullName());
            contentPanel.setContent(layout);
            contentPanel.setIcon(VaadinIcons.CLOCK);
            layout.setMargin(true);
            layout.setSpacing(false);
            StackPanel stackPanel =  StackPanel.extend(contentPanel);
            addComponent(contentPanel);
        }
    }
}
