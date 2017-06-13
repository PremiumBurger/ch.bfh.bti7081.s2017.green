package ch.bfh.bti7081.s2017.green.ui.components.myday;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

/**
 * Defines all Methods which can be used in the view from the presenter
 */
public interface MyDayViewListener {
    void getData();
    void onConfirmClicked(AppointmentBean appointmentBean);
    void onCancelledClicked(AppointmentBean appointmentBean);
}
