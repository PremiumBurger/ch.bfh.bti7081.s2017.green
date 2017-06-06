package ch.bfh.bti7081.s2017.green.ui.components.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 15.05.17.
 */
@Component
public class AlarmViewPresenter implements AlarmViewListener {
    Alarm alarm;
    AlarmView alarmView;

    @Autowired
    public AlarmViewPresenter(Alarm alarm, AlarmView alarmView) {
        this.alarm = alarm;
        this.alarmView = alarmView;
    }

    @Override
    public void onInit() {
        alarmView.init();
    }
}
