package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.ui.stub.PmsDummyImages;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppointmentDetailViewImpl extends VerticalLayout implements AppointmentDetailView {


    private AppointmentDetailViewListener viewListener;

    private AppointmentBean model;

    private Set<AppointmentStateTypeBean> allApppointmentStates;

    private Set<PatientBean>  allPatients;

    private boolean isUpdateMode;

    //Buttons for State
    Button confirmAppointment;
    Button cancelAppointment;

    /**
     * Needs to be global to update this partially
     */
    private HorizontalLayout involvedLayout;

    @Override
    public void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients, Set<AppointmentStateTypeBean> allApppointmentStates) {
        this.allPatients = allPatients;
        this.allApppointmentStates = allApppointmentStates;
        model = appointmentBean;
        initializeView();
    }

    private void initializeView() {
        removeAllComponents();
        setResponsive(true);

        // set page title
        addComponent(new H1Title("Appointment (#" + model.getId() + ")"));

        // set appointment details
        addComponent(buildAppointmentDetail());

        // add button bar
        addComponent(buildButtonbar());

        // set patient and healthvisitor details
        involvedLayout = buildInvolved();
        addComponent(involvedLayout);

        // linked journal entries
        // TODO: aluege mitm Tobi!
    }

    private HorizontalLayout buildInvolved() {
        HorizontalLayout involvedLayout = new HorizontalLayout();
        involvedLayout.setWidth(100, Unit.PERCENTAGE);
        involvedLayout.addComponents(buildHealthVisitorDetail(), buildPatientDetail());
        return involvedLayout;
    }

    private HorizontalLayout buildButtonbar() {
        HorizontalLayout buttonBarLayout = new HorizontalLayout();
        buttonBarLayout.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
        buttonBarLayout.setWidth(100, Unit.PERCENTAGE);
        HorizontalLayout buttons = new HorizontalLayout();
        buttonBarLayout.addComponent(buttons);

        if (isUpdateMode) {
            Button cancelButton = new Button("Cancel");
            Button saveButton = new Button("Save", VaadinIcons.DISC);
            buttons.addComponents(cancelButton, saveButton);

            cancelButton.addClickListener(event -> {
                isUpdateMode = false;
                model.reset();
                initializeView();
            });

            saveButton.addClickListener(event -> {
                isUpdateMode = false;
                viewListener.saveAppointment(model);
                initializeView();
                Notification.show("Appointment has bees saved successfully");
            });

            //Confirm Appointment (State)
            confirmAppointment = new Button("Confirm");
            confirmAppointment.setIcon(VaadinIcons.BUG);
            //confirmAppointment.setVisible(false);

            //Cancel Appointment (State)
            cancelAppointment = new Button("Cancel");
            confirmAppointment.setIcon(VaadinIcons.BUG);
            //confirmAppointment.setVisible(false);

            //CLicklistener for Appointment Confirm
            confirmAppointment.addClickListener(e -> viewListener.onConfirmClicked(model));

            //CLicklistener for Appointment Confirm
            cancelAppointment.addClickListener(e -> viewListener.onCancelledClicked(model));

            buttons.addComponent(confirmAppointment);
            buttons.addComponent(cancelAppointment);

            // styles
            buttonBarLayout.setResponsive(true);
            cancelButton.addStyleName(ValoTheme.BUTTON_DANGER);
            saveButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        } else {
            Button editButton = new Button("Edit", VaadinIcons.EDIT);
            buttons.addComponent(editButton);

            editButton.addClickListener( event -> {
               isUpdateMode = true;
               initializeView();
            });

            // styles
            editButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        }

        return buttonBarLayout;
    }

    private Panel buildHealthVisitorDetail() {
        HealthVisitorBean hvModel = model.getHealthVisitor();

        // layout
        Panel healthVisitorDetails = new Panel("Health Visitor (#" + hvModel.getId() + ")");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setMargin(true);

        FormLayout hvForm = new FormLayout();
        hvForm.setMargin(true);
        horizontalLayout.addComponents(PmsDummyImages.getHealthVisitorImage(), hvForm);

        healthVisitorDetails.setContent(horizontalLayout);

        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        firstName.setEnabled(false);
        lastName.setEnabled(false);
        hvForm.addComponents(firstName, lastName);

        // bindings
        Binder<HealthVisitorBean> binder = new Binder<>(HealthVisitorBean.class);
        binder.forField(firstName).bind(HealthVisitorBean::getFirstName, HealthVisitorBean::setFirstName);
        binder.forField(lastName).bind(HealthVisitorBean::getLastName, HealthVisitorBean::setLastName);
        binder.setBean(hvModel);

        // styling
        healthVisitorDetails.setResponsive(true);
        healthVisitorDetails.setWidth(100, Unit.PERCENTAGE);
        return healthVisitorDetails;
    }

    private Panel buildPatientDetail() {
        PatientBean patModel = model.getPatient();

        // layout
        Panel patientDetails = new Panel("Patient (#" + patModel.getId() + ")");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setMargin(true);
        FormLayout patForm = new FormLayout();
        horizontalLayout.addComponents(PmsDummyImages.getPatientImage(), patForm);
        patForm.setMargin(true);
        patientDetails.setContent(horizontalLayout);

        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        firstName.setEnabled(false);
        lastName.setEnabled(false);
        patForm.addComponents(firstName, lastName);

        // bindings
        Binder<PatientBean> binder = new Binder<>(PatientBean.class);
        binder.forField(firstName).bind("firstName");
        binder.forField(lastName).bind("lastName");
        binder.setBean(patModel);

        // styling
        patientDetails.setResponsive(true);
        patientDetails.setWidth(100, Unit.PERCENTAGE);
        return patientDetails;
    }

    private Panel buildAppointmentDetail() {
        Panel appointmentDetailPanel = new Panel("Details");
        HorizontalLayout appForm = new HorizontalLayout();
        appForm.setMargin(true);
        appointmentDetailPanel.setContent(appForm);
        BeanValidationBinder binder = new BeanValidationBinder<>(AppointmentBean.class);

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
        appForm.addComponents(from, to, comboBoxPatient, comboBoxState);

        // mode specific
        from.setEnabled(isUpdateMode);
        to.setEnabled(isUpdateMode);
        comboBoxPatient.setEnabled(isUpdateMode);
        comboBoxState.setEnabled(isUpdateMode);

        // bindings
        binder.forField(from).bind("from");
        binder.forField(to).bind("to");
        binder.forField(comboBoxPatient).bind("patient");
        binder.forField(comboBoxState).bind("appointmentStateType");
        binder.setBean(model);

        // events
        comboBoxPatient.addValueChangeListener(event -> {
            if (binder.isValid()) {
                removeComponent(involvedLayout);
                involvedLayout = buildInvolved();
                addComponent(involvedLayout);
            }
        });

        // styles
        appointmentDetailPanel.setResponsive(true);
        appForm.setResponsive(true);
        return appointmentDetailPanel;
    }

    @Override
    public void setListener(AppointmentDetailViewListener appDetailViewListener) {
        this.viewListener = appDetailViewListener;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        String parameters = event.getParameters();
        viewListener.initScreen(Long.valueOf(parameters));
    }

    public void updateConfirmButton(boolean visible, String buttonCaption){
        confirmAppointment.setVisible(visible);
        confirmAppointment.setCaption(buttonCaption);
    }

    public void updateCancelButton(boolean visible, String buttonCaption){
        cancelAppointment.setVisible(visible);
        cancelAppointment.setCaption(buttonCaption);
    }
}
