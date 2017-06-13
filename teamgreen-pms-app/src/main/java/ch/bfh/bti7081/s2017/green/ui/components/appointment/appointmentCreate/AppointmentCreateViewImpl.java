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
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * View Class (MVP) for Creating new Appointments
 * @author schms27
 */
@Component
public class AppointmentCreateViewImpl extends VerticalLayout implements AppointmentCreateView {

    private AppointmentCreateViewListener viewListener;
    private AppointmentBean model;
    private Set<AppointmentStateTypeBean> allApppointmentStates;
    private Set<PatientBean>  allPatients;
    private BeanValidationBinder<AppointmentBean> binder = new BeanValidationBinder<>(AppointmentBean.class);

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

        DateTimeField from = new DateTimeField("From");
        DateTimeField to = new DateTimeField("To");
        from.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);
        to.setDateFormat(PmsConstants.SWISS_DATE_FORMAT);

        ComboBox<PatientBean> comboBoxPatient = new ComboBox<>("Patient");
        comboBoxPatient.setItems(allPatients);
        comboBoxPatient.setItemCaptionGenerator(PersonBean::getFullName);

        ComboBox<AppointmentStateTypeBean> comboBoxState = new ComboBox<>("State");
        comboBoxState.setItems(allApppointmentStates);
        comboBoxState.setItemCaptionGenerator(p -> p.getDescription());
        comboBoxState.setEnabled(false);

        appForm.addComponents(from, to, comboBoxPatient, comboBoxState);

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
        binder.forField(comboBoxState).bind("appointmentStateType");
        binder.setBean(model);

        // events
        comboBoxPatient.addValueChangeListener(event -> initializeView());

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
            viewListener.initScreen(1);
            initializeView();
        });
        saveButton.addClickListener(event -> {
            if(binder.isValid()) {
                viewListener.saveAppointment(model);
                initializeView();
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
        //String parameters = event.getParameters();
        //TODO: angemeldeten Healtvisitor mitgeben
        viewListener.initScreen(1);
    }
}
