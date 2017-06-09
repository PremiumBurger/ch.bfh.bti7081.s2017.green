package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import ch.bfh.bti7081.s2017.green.ui.stub.PmsDummyImages;
import com.vaadin.data.Binder;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.stereotype.Component;
import com.vaadin.ui.*;

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
        PatientBean patModel = this.patientBean;

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
}
