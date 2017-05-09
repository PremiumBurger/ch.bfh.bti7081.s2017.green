package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

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
}
