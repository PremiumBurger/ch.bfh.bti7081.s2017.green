package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.myday.*;
import com.vaadin.navigator.View;

import java.util.List;

/**
 * Created by joris on 26.05.17.
 */
public interface AppointmentView extends View{
    void addListener(AppointmentViewListener appointmentViewListener);

    void init(AppointmentBean appointment, List<PatientBean> patients);

    void saveChanges();
}
