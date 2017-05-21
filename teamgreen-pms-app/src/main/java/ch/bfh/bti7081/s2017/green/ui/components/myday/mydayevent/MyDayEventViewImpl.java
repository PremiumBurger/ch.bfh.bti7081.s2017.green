package ch.bfh.bti7081.s2017.green.ui.components.myday.mydayevent;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortView;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortViewImpl;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 15.05.17.
 */
@Component
public class MyDayEventViewImpl extends VerticalLayout implements MyDayEventView {

    AppointmentBean appointmentModel;
    private Label appointmentTitle;
    private Label appointmentTime;

    private PatientShortView patientShortView;

    @Autowired
    public MyDayEventViewImpl(PatientShortView patientShortView) {
        this.patientShortView = patientShortView;
        appointmentTitle = new Label("");
        appointmentTime = new Label("");
        addComponents(appointmentTitle,appointmentTime,(PatientShortViewImpl)patientShortView);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @Override
    public void addListener(MyDayEventViewListener listener) {

    }

    @Override
    public void init(AppointmentBean appointment) {
        appointmentModel = appointment;
        appointment.g
    }
}
