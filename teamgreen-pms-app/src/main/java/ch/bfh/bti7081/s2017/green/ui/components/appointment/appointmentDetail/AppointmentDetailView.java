package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentJournalEntryBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.LocationBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;

import java.util.Set;

public interface AppointmentDetailView extends View {

    /**
     * Sets the ViewListener of this view
     * @param appDetailViewListener the {@link AppointmentDetailViewListener} to set
     */
    void setListener(AppointmentDetailViewListener appDetailViewListener);

    /**
     * Sets the Model of the View
     * @param appointmentBean the appoinmentBean which will be populated to the screen
     * @param allPatients the list of all available patients
     * @param allApppointmentStates al list of all available appointment states
     * @param locationBean the location bean
     */
    void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients, Set<AppointmentStateTypeBean> allApppointmentStates, LocationBean locationBean);

    void openModal(AppointmentJournalEntryBean bean);

    /**
     * Updates the two State-dependent Buttons on the view
     * @param confirmButtonVisible sets confirm button visible/invisible
     * @param confirmButtonCaption sets caption of the confirm button
     * @param cancelButtonVisible sets cancel button visible/invisible
     * @param cancelButtonCaption sets caption of cancel button
     */
    void updateStateButtons(boolean confirmButtonVisible, String confirmButtonCaption, boolean cancelButtonVisible, String cancelButtonCaption);
}
