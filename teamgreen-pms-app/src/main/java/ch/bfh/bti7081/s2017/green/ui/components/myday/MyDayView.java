package ch.bfh.bti7081.s2017.green.ui.components.myday;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import com.vaadin.navigator.View;
import java.util.List;

/**
 * Inherits from Vaadin Navigator View and defines which methods are available on the View Implementation
 */
public interface MyDayView extends View {
    void addListener(MyDayViewListener viewListener);
    void init(List<AppointmentBean> appointments);
}
