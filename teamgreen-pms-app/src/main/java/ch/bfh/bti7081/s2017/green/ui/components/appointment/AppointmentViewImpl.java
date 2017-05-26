package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.provider.ListDataProvider;
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

    private long appointmentId;

    private DateTimeField from;
    private DateTimeField to;
    private ComboBox<PatientBean> comboBox;
    private Button save;

    private Label firstname;
    private Label lastname;
    private Label street;
    private Label adr;

    public AppointmentViewImpl() {
        FormLayout layout = new FormLayout();

        from = new DateTimeField();
        to = new DateTimeField();
        comboBox = new ComboBox<>();
        save = new Button("Save");
        save.setIcon(VaadinIcons.SAFE);

        FormLayout patientForm = new FormLayout();

        firstname = new Label();
        firstname.setCaption("Vorname");
        lastname = new Label();
        lastname.setCaption("Nachname");
        street = new Label();
        street.setCaption("Strasse");
        adr = new Label();
        adr.setCaption("PLZ/Ort");

        patientForm.addComponents(firstname,lastname,street,adr);
        layout.addComponents(from,to,comboBox,patientForm,save);
        setViewContent(layout);




    }

    @Override
    public void addListener(AppointmentViewListener appointmentViewListener) {

    }

    @Override
    public void init(AppointmentBean appointment, List<PatientBean> patients) {
        from.setCaption("Von");
        from.setValue(appointment.getFrom());
        to.setCaption("Bis");
        to.setValue(appointment.getTo());
        comboBox.setCaption("Patient");
        comboBox.setItems(patients);
        comboBox.setItemCaptionGenerator(PatientBean::getLastName);
        comboBox.addValueChangeListener(event -> {
            PatientBean patient = patients.stream().filter(p -> p.getId() == event.getValue().getId()).findFirst().get();
            firstname.setValue(patient.getFirstName());
            lastname.setValue(patient.getLastName());
            street.setValue(patient.getAddress().getStrasse());
            adr.setValue(patient.getAddress().getPlz() + " " + patient.getAddress().getCity());
        });


    }

    @Override
    public void saveChanges() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {


    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
