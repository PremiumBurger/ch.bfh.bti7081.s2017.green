package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;


import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.ui.controls.H2Title;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * View Class (MVP) for Creating new Appointments
 * @author schms27
 */
@Component
public class AppointmentCreateViewImpl extends VerticalLayout implements AppointmentCreateView {

    private AppointmentCreateViewListener viewListener;
    private AppointmentBean model;
    private Set<PatientBean>  allPatients;
    private BeanValidationBinder<AppointmentBean> binder;
    private BeanValidationBinder<AddressBean> addressBinder;

    @Override
    public void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients) {
        this.model = appointmentBean;
        this.allPatients = allPatients;
        initializeView();
    }

    private void initializeView() {
        removeAllComponents();
        setResponsive(true);

        // set page title
        addComponent(new H1Title("New Appointment"));

        // set appointment details
        addComponent(buildAppointmentCreate());

        // add button bar
        addComponent(buildButtonbar());
    }

    @Override
    public void setListener(AppointmentCreateViewListener appCreateViewListener) {
        this.viewListener = appCreateViewListener;
    }

    private Panel buildAppointmentCreate() {
        Panel appointmentCreatePanel = new Panel("Details");
        binder = new BeanValidationBinder<>(AppointmentBean.class);
        addressBinder = new BeanValidationBinder<>(AddressBean.class);

        HorizontalLayout formContainer = new HorizontalLayout();

        VerticalLayout appForm = new VerticalLayout();
        VerticalLayout addressForm = new VerticalLayout();
        appForm.setMargin(true);
        addressForm.setMargin(true);
        appointmentCreatePanel.setContent(formContainer);

        DateTimeField from = new DateTimeField("From");
        DateTimeField to = new DateTimeField("To");
        from.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);
        to.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);

        ComboBox<PatientBean> comboBoxPatient = new ComboBox<>("Patient");
        comboBoxPatient.setItems(allPatients);
        comboBoxPatient.setItemCaptionGenerator(PersonBean::getFullName);

        appForm.addComponents(new H2Title("Appointment"), from, to, comboBoxPatient);

        TextField street = new TextField("Street");
        TextField postalCode = new TextField("Postal Code");
        TextField city = new TextField("City");
        addressForm.addComponents(new H2Title("Appointment Location"), street, postalCode, city);

        formContainer.addComponents(appForm, addressForm);

        // bindings
        binder.forField(from)
                .withValidator(f ->  to.getValue()==null || f.isBefore(to.getValue()),
                        "End Date can not be before Start Date")
                .bind("from");
        binder.forField(to)
                .withValidator(t -> from.getValue().isBefore(t),
                        "End Date can not be before Start Date")
                .bind("to");
        binder.forField(comboBoxPatient).bind("patient");
        binder.setBean(model);

        addressBinder.forField(street).bind("strasse");
        addressBinder.forField(postalCode).bind("plz");
        addressBinder.forField(city).bind("city");
        addressBinder.setBean(model.getAddress());

        // styles
        appointmentCreatePanel.setResponsive(true);
        appForm.setResponsive(true);
        return appointmentCreatePanel;
    }

    private HorizontalLayout buildButtonbar() {
        HorizontalLayout buttonBarLayout = new HorizontalLayout();
        buttonBarLayout.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
        buttonBarLayout.setWidth(100, Unit.PERCENTAGE);
        HorizontalLayout buttons = new HorizontalLayout();
        buttonBarLayout.addComponent(buttons);

        // buttons
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save", VaadinIcons.DISC);
        Button resetButton = new Button("Reset", VaadinIcons.BACKWARDS);
        buttons.addComponents(cancelButton,resetButton, saveButton);

        // add listeners to buttons
        cancelButton.addClickListener(event ->
            getUI().getNavigator().navigateTo("MyDay")
        );
        resetButton.addClickListener(event -> {
            model.reset();
            initializeView();
        });
        saveButton.addClickListener(event -> {
            if(binder.isValid() && addressBinder.isValid()) {
                viewListener.saveAppointment(model);
                getUI().getNavigator().navigateTo("MyDay");
            }
        });

        // styles
        buttonBarLayout.setResponsive(true);
        cancelButton.addStyleName(ValoTheme.BUTTON_DANGER);
        saveButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        return buttonBarLayout;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        viewListener.initScreen();
    }
}
