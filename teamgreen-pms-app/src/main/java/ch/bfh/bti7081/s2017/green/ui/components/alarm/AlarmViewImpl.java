package ch.bfh.bti7081.s2017.green.ui.components.alarm;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

/**
 * Created by joris on 15.05.17.
 */
@Component
public class AlarmViewImpl extends VerticalLayout implements AlarmView{
    AlarmViewListener listener;
    Button alarm;
    PopupView alarmPopUp;
    VerticalLayout alarmConentPopUp;

    public AlarmViewImpl() {
        alarm = new Button("Alarm");
        alarm.setIcon(VaadinIcons.BELL_O);
        alarm.setWidth("100%");
        alarm.setHeight("100%");
        alarm.addStyleName(ValoTheme.BUTTON_DANGER);
        alarm.addClickListener(e -> alarmPopUp.setPopupVisible(true));

        alarmConentPopUp = new VerticalLayout();
        Label helpMessage = new Label("Help is Comming!!!");
        alarmConentPopUp.addComponent(helpMessage);

        alarmPopUp = new PopupView("Alarm", alarmConentPopUp);
        alarmPopUp.addStyleName(ValoTheme.NOTIFICATION_WARNING);

        addComponents(alarm, alarmPopUp);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    @Override
    public void addListener(AlarmViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void init() {

    }
}
