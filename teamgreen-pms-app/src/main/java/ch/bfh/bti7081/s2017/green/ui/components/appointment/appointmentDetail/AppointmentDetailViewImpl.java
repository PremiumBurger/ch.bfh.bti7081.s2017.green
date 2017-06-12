package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.*;
import ch.bfh.bti7081.s2017.green.ui.controls.H1Title;
import ch.bfh.bti7081.s2017.green.ui.stub.PmsDummyImages;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
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

        // add appointment detail and map
        addComponent(buildDetailAndMap());

        // set patient and healthvisitor details
        involvedLayout = buildInvolved();
        addComponent(involvedLayout);

        // linked journal entries
        // TODO: aluege mitm Tobi!
    }

    private HorizontalLayout buildDetailAndMap() {
        HorizontalLayout detailMapLayout = new HorizontalLayout();
        VerticalLayout detailButtonLayout = new VerticalLayout();
        detailButtonLayout.addComponents(buildAppointmentDetail(), buildButtonbar());
        detailMapLayout.addComponents(detailButtonLayout, buildLocationMap());

        // styles
        detailMapLayout.setWidth(100, Unit.PERCENTAGE);
        detailButtonLayout.setMargin(false);

        return detailMapLayout;
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

    private Panel buildLocationMap() {
        Panel panel = new Panel("Location");
        VerticalLayout mapLayout = new VerticalLayout();
        GoogleMap googleMap = new GoogleMap(PmsConstants.GOOGLE_MAPS_API_KEY, null, "german");
        googleMap.setSizeFull();
        LatLon bfhBern = new LatLon(46.964815, 7.456026);
        googleMap.addMarker("Appointment Location", bfhBern, false, null);
        googleMap.setCenter(bfhBern);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);
        mapLayout.addComponent(googleMap);
        panel.setContent(mapLayout);
        panel.setWidth(100, Unit.PERCENTAGE);
        return panel;
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
