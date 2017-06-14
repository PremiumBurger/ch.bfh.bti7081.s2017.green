package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.domain.Patient;
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
     */
    void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients, Set<AppointmentStateTypeBean> allApppointmentStates);

    void updateStateButtons(boolean confirmButtonVisible, String confirmButtonCaption, boolean cancelButtonVisible, String cancelButtonCaption);
}
