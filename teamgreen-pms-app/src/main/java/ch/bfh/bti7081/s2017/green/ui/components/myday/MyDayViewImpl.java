package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyDayViewImpl extends MasterPageImpl implements MyDayView {

    private List<MyDayViewListener> listeners;

    public MyDayViewImpl() {
        VerticalLayout myDayContent = new VerticalLayout();
        Label lbl = new Label("Hello World!");
        myDayContent.addComponent(lbl);
        setViewContent(myDayContent);
        this.listeners = new ArrayList<>();
    }

    @Override
    public void addListener(MyDayViewListener viewListener) {
        listeners.add(viewListener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
