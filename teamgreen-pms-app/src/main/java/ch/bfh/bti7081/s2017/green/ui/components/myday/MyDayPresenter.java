package ch.bfh.bti7081.s2017.green.ui.components.myday;

import org.springframework.beans.factory.annotation.Autowired;

public class MyDayPresenter implements MyDayViewListener {

    MyDay myDay;
    MyDayView myDayView;

    @Autowired
    public MyDayPresenter(MyDay myDay, MyDayView myDayView) {
        this.myDay = myDay;
        this.myDayView = myDayView;

        myDayView.addListener(this);
    }

    @Override
    public void doSearch() {

    }

    @Override
    public void setAlarm() {

    }

    @Override
    public void showPatientDetails() {

    }

    @Override
    public void showMedication() {

    }
}
