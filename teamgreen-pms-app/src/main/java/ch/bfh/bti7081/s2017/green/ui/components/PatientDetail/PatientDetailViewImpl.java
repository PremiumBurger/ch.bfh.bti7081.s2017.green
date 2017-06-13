package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.stub.PmsDummyImages;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import org.springframework.stereotype.Component;
import com.vaadin.ui.*;
import org.vaadin.addons.stackpanel.StackPanel;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by mathewthekkekara on 06.06.17.
 */
@Component
public class PatientDetailViewImpl extends VerticalLayout implements PatientDetailView {
    private PatientDetailViewListener listener;
    private PatientBean patientBean;
    private List<AppointmentBean> appointments;
    private ComboBox<AppointmentBean> appointmentSearch;

    public PatientDetailViewImpl() {
        appointmentSearch = new Autocomplete<AppointmentBean>();
        appointmentSearch.setWidth("100%");
        appointmentSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
                appointmentSearch.setValue(null);
                getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + e.getValue().getId());
            }
        });
    }

    public void initializeView(){
        removeAllComponents();

        addComponent(buildPatientDetail());
        addComponent(buildPatientsAppointments());
        addComponent(buidPatientJournal());
        addComponent(buildPromisses());
        addComponent(buildEmergency());
        addComponent(buildEmergencyBox());
    }

    @Override
    public void addListener(PatientDetailViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init(PatientBean patient) {

    }

    @Override
    public void setModel(PatientBean patientBean, List<AppointmentBean> appointments) {
        this.patientBean = patientBean;
        this.appointments = appointments;
        this.initializeView();
    }

    @Override
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        String parameters = event.getParameters();
        listener.initScreen(Long.valueOf(parameters));
    }

    private Panel buildPatientDetail() {
        Panel panel = new Panel( patientBean.getFirstName()+" "+patientBean.getLastName() +"(#"+patientBean.getId()+")");
        HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();

        //components
        Label name = new Label("Name");
        Label ahv = new Label("AHV Nr.");
        Label address = new Label("Address");
        Label tel = new Label("Telefon");
        Grid<HealthVisitorBean> hv = new Grid<>();

        //componentStyles
        hv.setWidth(100,Unit.PERCENTAGE);

        //Caption Components
        name.setCaption("Name :");
        ahv.setCaption("AHV Nr. :");
        address.setCaption("Address :");
        tel.setCaption("Telefon :");
        hv.setCaption("Healthvisitor");

        //values of components
        name.setValue(patientBean.getFullName());
        ahv.setValue(patientBean.getAhvNr());
        address.setValue(patientBean.getAddress().getStrasse()+" "+patientBean.getAddress().getPlz()+" "+patientBean.getAddress().getCity());
        tel.setValue(patientBean.getPhone());
        hv.setItems(patientBean.getHealthVisitors());
        hv.addColumn(HealthVisitorBean::getName).setCaption("Name");

        //add labels to component
        vertical.addComponents(name,ahv,address,tel,hv);

        horizontal.addComponent(vertical);
        horizontal.addComponent(PmsDummyImages.getPatientImage());
        panel.setContent(horizontal);
        StackPanel.extend(panel);


        // styling
        panel.setResponsive(true);
        panel.setWidth(100, Unit.PERCENTAGE);
        return panel;
    }

    private Panel buildPatientsAppointments() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(PmsConstants.SWISS_DATE_FORMAT);
        Panel panel = new Panel("Appointments list");
        Grid<AppointmentBean> grid = new Grid<>();
        grid.setCaption("Appointments");
        grid.setItems(patientBean.getAppointments());
        grid.addColumn(app -> app.getFrom().format(format)).setCaption("From");
        grid.addColumn(app -> app.getTo().format(format)).setCaption("To");
        grid.addColumn(app -> app.getAppointmentStateType().getDescription()).setCaption("State");

        //render a Button that navigates to Appointment Detail
        grid.addSelectionListener(e -> {
            getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + e.getFirstSelectedItem().get().getId());
        });

        //style of Grid
        grid.setWidth(100,Unit.PERCENTAGE);
        grid.setResponsive(true);

        panel.setContent(grid);
        //TODO medication anzeigen ?
        StackPanel.extend(panel);

        return panel;
    }

    private Panel buidPatientJournal() {
        Panel panel = new Panel("Journal");
        //TODO unterer Code auskomentieren sobald JournalEntryListComponent übernommen
        //com.vaadin.ui.Component journal = addComponent(new JournalEntryListComponent(patientBean.getJournal().getJournalEntries()));
        //panel.setContent(journal);

        StackPanel.extend(panel);
        return panel;
    }

    private Panel buildPromisses() {
        Panel promisses = new Panel("Promisses");
        StackPanel.extend(promisses);
        return promisses;

    }

    private Panel buildEmergency() {
        Panel emergency = new Panel("emergency");
        StackPanel.extend(emergency);
        return emergency;
    }

    private Panel buildEmergencyBox() {
        Panel emergencyBox = new Panel("Emergency Box");
        StackPanel.extend(emergencyBox);
        return emergencyBox;
    }
}


