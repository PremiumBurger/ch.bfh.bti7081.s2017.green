package ch.bfh.bti7081.s2017.green.ui.components.myday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Connects Model and View
 * Implements MydayViewListener
 */
@Component
public class MyDayPresenter implements MyDayViewListener {

    /**
     * Declaration of myDayView
     * Access to MyDay Model
     */
    private MyDay myDay;
    /**
     * Declaration of myDayView
     * Access to MyDay View
     */
    private MyDayView myDayView;

    /**
     * @param myDay Initializes Model through Spring Autowired
     * @param myDayView Initializes View through Spring Autowired
     * Adds this presenter to the view
     */
    @Autowired
    public MyDayPresenter(MyDay myDay, MyDayView myDayView) {
        this.myDay = myDay;
        this.myDayView = myDayView;
        myDayView.addListener(this);
    }

    /**
     * Get's Data from myDay Model and passes it to the view through the init method
     */
    @Override
    public void getData() {
        myDayView.init(myDay.getAll());
    }
}
