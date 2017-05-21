package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortView;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortViewImpl;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyDayViewImpl extends MasterPageImpl implements MyDayView {

    MyDayViewListener listener;

    private PatientShortView patientShortView;

    @Autowired
    public MyDayViewImpl(PatientShortView patientShortView) {
        this.patientShortView = patientShortView;
        setViewContent((PatientShortViewImpl)patientShortView);
    }

    @Override
    public void addListener(MyDayViewListener viewListener) {
        this.listener = viewListener;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
