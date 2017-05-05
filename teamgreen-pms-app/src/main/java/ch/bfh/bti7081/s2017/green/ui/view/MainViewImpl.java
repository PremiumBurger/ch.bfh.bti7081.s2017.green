package ch.bfh.bti7081.s2017.green.ui.view;

import com.vaadin.ui.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 05.05.17.
 */
public class MainViewImpl extends HorizontalLayout implements MainView{
    private List<MainViewListener> listeners;

    public MainViewImpl() {
        this.listeners = new ArrayList<>();
    }

    @Override
    public void addListener(MainViewListener viewListener) {
        listeners.add(viewListener);
    }
}
