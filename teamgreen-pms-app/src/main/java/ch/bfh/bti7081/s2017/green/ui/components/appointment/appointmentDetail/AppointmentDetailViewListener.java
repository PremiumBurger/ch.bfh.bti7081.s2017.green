package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.JournalEntryBean;

public interface AppointmentDetailViewListener {

    /**
     * Gets the initial Data for this Screen
     * @param appointmentId the appointmentId
     */
    void initScreen(long appointmentId);

    /**
     * Persists an {@link AppointmentBean}
     * @param appointmentBean the {@link AppointmentBean} to persist
     */
    void saveAppointment(AppointmentBean appointmentBean);

    /**
     * on Click event handler for add-journal-entry-button
     */
    void onAddJournalEntryButtonClick();


    /**
     * event which gets fired when the state confirm button gets clicked
     * @param appointmentBean the bean to act on
     */
    void onConfirmClicked(AppointmentBean appointmentBean);

    /**
     * event which gets fired when the state cancel button gets clicked
     * @param appointmentBean the bean to act on
     */
    void onCancelledClicked(AppointmentBean appointmentBean);

    /**
     * event to trigger a refresh of the view dependent on the momentary state
     * @param appointmentBean the bean to act on
     */
    void getStateRefresh(AppointmentBean appointmentBean);

    /**
     * Refresh the Location
     * @param addressBean the {@link AddressBean}
     */
    void updateLocation(AddressBean addressBean);

}
