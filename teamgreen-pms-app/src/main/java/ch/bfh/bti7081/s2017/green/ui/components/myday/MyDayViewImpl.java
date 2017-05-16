package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import ch.bfh.bti7081.s2017.green.ui.components.patient.patientshort.PatientShortViewImpl;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyDayViewImpl extends MasterPageImpl implements MyDayView {

    private List<MyDayViewListener> listeners;

    public MyDayViewImpl() {
        setViewContent(new PatientShortViewImpl());

    }

    @Override
    public void addListener(MyDayViewListener viewListener) {
        listeners.add(viewListener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
