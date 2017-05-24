package ch.bfh.bti7081.s2017.green.ui.components.myday.mydayevent;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortListener;
import com.vaadin.navigator.View;

/**
 * Created by joris on 15.05.17.
 */
public interface MyDayEventView extends View{
    void addListener(MyDayEventViewListener listener);



    void init(AppointmentBean appointment);
}
