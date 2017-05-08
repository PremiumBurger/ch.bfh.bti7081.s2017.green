package ch.bfh.bti7081.s2017.green.ui.view.component.myDay;


import java.util.ArrayList;
import java.util.List;

public class MyDayViewImpl implements MyDayView {

    private List<MyDayViewListener> listeners;

    public MyDayViewImpl() {
        this.listeners = new ArrayList<>();
    }

    @Override
    public void addListener(MyDayViewListener viewListener) {
        listeners.add(viewListener);
    }
}
