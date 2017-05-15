package ch.bfh.bti7081.s2017.green.ui.components.myday.mydayevent;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by joris on 15.05.17.
 */
public class MyDayEventViewImpl implements MyDayEventView {

    private String time;
    private String title;


    public MyDayEventViewImpl() {
        VerticalLayout layout = new VerticalLayout();
        Label label = new Label();

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
