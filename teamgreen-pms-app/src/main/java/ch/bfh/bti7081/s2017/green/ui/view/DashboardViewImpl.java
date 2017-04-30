package ch.bfh.bti7081.s2017.green.ui.view;


import java.util.ArrayList;
import java.util.List;

public class DashboardViewImpl implements DashboardView {

    private List<DashboardViewListener> listeners;

    public DashboardViewImpl() {
        this.listeners = new ArrayList<>();
    }

    @Override
    public void addListener(DashboardViewListener viewListener) {
        listeners.add(viewListener);
    }
}
