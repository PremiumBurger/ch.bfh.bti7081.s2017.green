package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.ui.controls.PmsDummyImages;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppointmentDetailViewImpl extends VerticalLayout implements AppointmentDetailView {


    private AppointmentDetailViewListener viewListener;

    private AppointmentBean model;

    private Set<PatientBean>  allPatients;

    private boolean isUpdateMode;

    @Override
    public void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients) {
        this.allPatients = allPatients;
        model = appointmentBean;
        initializeView();
    }


    private void initializeView() {
        removeAllComponents();

        // set page title
        addComponent(new H1Title("Appointment Detail (#" + model.getId() + ")"));

        // set appointment details
        addComponent(buildAppointmentDetail());

        // add button bar
        addComponent(buildButtonbar());

        // set patient and healthvisitor details
        HorizontalLayout involvedLayout = new HorizontalLayout();
        involvedLayout.setWidth(100, Unit.PERCENTAGE);
        involvedLayout.addComponents(buildHealthVisitorDetail(), buildPatientDetail());
        addComponent(involvedLayout);

        // linked journal entries

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

        } else {
            Button editButton = new Button("Edit", VaadinIcons.EDIT);
            buttons.addComponent(editButton);

            editButton.addClickListener( event -> {
               isUpdateMode = true;
               initializeView();
            });
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
        patientDetails.setWidth(100, Unit.PERCENTAGE);
        return patientDetails;
    }

    private Panel buildAppointmentDetail() {
        Panel appointmentDetailPanel = new Panel("Details");
        HorizontalLayout appForm = new HorizontalLayout();
        appForm.setMargin(true);
        appForm.setSpacing(true);
        appointmentDetailPanel.setContent(appForm);
        BeanValidationBinder binder = new BeanValidationBinder<>(AppointmentBean.class);
        DateTimeField from = new DateTimeField("From");
        DateTimeField to = new DateTimeField("To");
        ComboBox<PatientBean> comboBoxPatient = new ComboBox<>("Patient");
        comboBoxPatient.setItems(allPatients);
        comboBoxPatient.setItemCaptionGenerator(PersonBean::getFullName);
        appForm.addComponents(from, to, comboBoxPatient);

        // visibility
        from.setEnabled(isUpdateMode);
        to.setEnabled(isUpdateMode);
        comboBoxPatient.setEnabled(isUpdateMode);

        // bindings
        binder.forField(from).bind("from");
        binder.forField(to).bind("to");
        binder.forField(comboBoxPatient).bind("patient");
        binder.setBean(model);

        // events
        comboBoxPatient.addValueChangeListener(event -> {
            initializeView();
        });

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
}
