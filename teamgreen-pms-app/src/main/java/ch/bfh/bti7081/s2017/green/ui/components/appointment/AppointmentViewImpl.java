package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by joris on 26.05.17.
 */
@Component
public class AppointmentViewImpl extends MasterPageImpl implements AppointmentView {

    private AppointmentViewListener listener;
    private AppointmentBean appointmentModel;
    private BeanValidationBinder<AppointmentBean> myDayBinder;

    private long appointmentId;

    private DateTimeField from;
    private DateTimeField to;
    private ComboBox<PatientBean> comboBoxPatient;
    private ComboBox<AppointmentStateTypeBean> comboBoxState;
    private Button save;

    private Label firstname;
    private Label lastname;
    private Label street;
    private Label adr;

    public AppointmentViewImpl() {
        FormLayout layout = new FormLayout();

        myDayBinder = new BeanValidationBinder<>(AppointmentBean.class);

        from = new DateTimeField();
        to = new DateTimeField();
        comboBoxPatient = new ComboBox<>();
        comboBoxState = new ComboBox<>();
        save = new Button("Save");
        save.setIcon(VaadinIcons.SAFE);
        save.addClickListener(l -> listener.save(myDayBinder.getBean()));

        FormLayout patientForm = new FormLayout();

        firstname = new Label();
        firstname.setCaption("Vorname");
        lastname = new Label();
        lastname.setCaption("Nachname");
        street = new Label();
        street.setCaption("Strasse");
        adr = new Label();
        adr.setCaption("PLZ/Ort");



        myDayBinder.forField(from)
                .bind(AppointmentBean::getFrom, AppointmentBean::setFrom);

        myDayBinder.forField(to)
                .bind(AppointmentBean::getTo, AppointmentBean::setTo);

        myDayBinder.forField(comboBoxPatient)
                .bind(AppointmentBean::getPatient, AppointmentBean::setPatient);

        myDayBinder.forField(comboBoxState).bind(AppointmentBean::getAppointmentStateType,
                AppointmentBean::setAppointmentStateType);




        patientForm.addComponents(firstname,lastname,street,adr);
        layout.addComponents(from,to, comboBoxPatient,comboBoxState,patientForm,save);
        setViewContent(layout);
    }

    @Override
    public void addListener(AppointmentViewListener appointmentViewListener) {
        this.listener = appointmentViewListener;
    }

    @Override
    public void init(AppointmentBean appointment, List<PatientBean> patients) {
        appointmentModel = appointment;
        myDayBinder.setBean(appointmentModel);

        from.setCaption("Von");
        from.setValue(appointment.getFrom());
        to.setCaption("Bis");
        to.setValue(appointment.getTo());
        comboBoxPatient.setCaption("Patient");
        comboBoxPatient.setItems(patients);
        comboBoxPatient.setValue(appointment.getPatient());
        firstname.setValue(appointment.getPatient().getFirstName());
        setPatientData(appointment.getPatient());
        comboBoxPatient.setItemCaptionGenerator(PatientBean::getLastName);
        comboBoxPatient.addValueChangeListener(event -> {
            PatientBean patient = patients.stream().filter(p -> p.getId() == event.getValue().getId()).findFirst().get();
            setPatientData(patient);

        });

        comboBoxState.setCaption("Appointment State");
        comboBoxState.setValue(appointment.getAppointmentStateType());
        comboBoxState.setItemCaptionGenerator(
                p -> p.getAppointmentState().getDescription()
        );



    }

    public void setPatientData(PatientBean patient){
        firstname.setValue(patient.getFirstName());
        lastname.setValue(patient.getLastName());
        street.setValue(patient.getAddress().getStrasse());
        adr.setValue(patient.getAddress().getPlz() + " " + patient.getAddress().getCity());

    }

    @Override
    public void saveChanges(AppointmentBean appointmentBean) {


    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        String param = event.getParameters();
        listener.getData(Long.valueOf(param).longValue());


    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
