package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;


import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.bean.PersonBean;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppointmentCreateViewImpl extends VerticalLayout implements AppointmentCreateView {

    private AppointmentCreateViewListener viewListener;
    private AppointmentBean model;
    private Set<AppointmentStateTypeBean> allApppointmentStates;
    private Set<PatientBean>  allPatients;

    @Override
    public void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients, Set<AppointmentStateTypeBean> allApppointmentStates) {
        this.model = appointmentBean;
        this.allPatients = allPatients;
        this.allApppointmentStates = allApppointmentStates;
        initializeView();
    }

    private void initializeView() {
        removeAllComponents();
        setResponsive(true);

        // set page title
        addComponent(new H1Title("New Appointment"));

        // set appointment details
        addComponent(buildAppointmentDetail());

        // add button bar
        addComponent(buildButtonbar());
    }

    @Override
    public void setListener(AppointmentCreateViewListener appCreateViewListener) {
        this.viewListener = appCreateViewListener;
    }

    private Panel buildAppointmentDetail() {
        Panel appointmentCreatePanel = new Panel("Details");
        VerticalLayout appForm = new VerticalLayout();
        appForm.setMargin(true);
        appointmentCreatePanel.setContent(appForm);
        BeanValidationBinder binder = new BeanValidationBinder<>(AppointmentBean.class);

        DateTimeField from = new DateTimeField("From");
        DateTimeField to = new DateTimeField("To");
        from.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);
        to.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);

        ComboBox<PatientBean> comboBoxPatient = new ComboBox<>("Patient");
        comboBoxPatient.setItems(allPatients);
        comboBoxPatient.setItemCaptionGenerator(PersonBean::getFullName);

        //TODO: Make this work!
        TextField textFieldState = new TextField("State");
        textFieldState.setDescription(model.getAppointmentStateType().getDescription());

        ComboBox<AppointmentStateTypeBean> comboBoxState = new ComboBox<>("State");
        comboBoxState.setItems(allApppointmentStates);
        comboBoxState.setItemCaptionGenerator(p -> p.getDescription());

        appForm.addComponents(from, to, comboBoxPatient, textFieldState);

        // bindings
        binder.forField(from).bind("from");
        binder.forField(to).bind("to");
        binder.forField(comboBoxPatient).bind("patient");
        binder.forField(comboBoxState).bind("appointmentStateType");
        //binder.forField(textFieldState).bind("appointmentStateType");
        binder.setBean(model);

        // events
        comboBoxPatient.addValueChangeListener(event -> {
            initializeView();
        });

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

        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save", VaadinIcons.DISC);
        Button resetButton = new Button("Reset", VaadinIcons.BACKWARDS);
        buttons.addComponents(cancelButton,resetButton, saveButton);

        cancelButton.addClickListener(event ->
                getUI().getNavigator().navigateTo("MyDay")
        );

        resetButton.addClickListener(event -> {
            model.reset();
            initializeView();
        });

        saveButton.addClickListener(event -> {
            viewListener.saveAppointment(model);
            initializeView();
            Notification.show("Appointment has bees saved successfully");
        });

        // styles
        buttonBarLayout.setResponsive(true);
        cancelButton.addStyleName(ValoTheme.BUTTON_DANGER);
        saveButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        return buttonBarLayout;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //String parameters = event.getParameters();
        //TODO: angemeldeten Healtvisitor mitgeben
        viewListener.initScreen(1);
    }
}
