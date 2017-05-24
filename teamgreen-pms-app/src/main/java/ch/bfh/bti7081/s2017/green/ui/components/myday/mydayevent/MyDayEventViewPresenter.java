package ch.bfh.bti7081.s2017.green.ui.components.myday.mydayevent;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.ui.components.patient.Patient;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 16.05.17.
 */
@Component
public class MyDayEventViewPresenter implements MyDayEventViewListener{

    private MyDayEvent event;                //Model
    private MyDayEventView myDayEventView;        //View

    @Autowired
    public MyDayEventViewPresenter(MyDayEventView myDayEventView, MyDayEvent event) {
        this.myDayEventView = myDayEventView;
            this.event = event;
        myDayEventView.addListener(this);
        myDayEventView.init(event.getSelectedEvents());
    }
}
