package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.AppointmentStateTypeBean;
import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;


import java.util.Set;

public interface AppointmentCreateView extends View {
    /**
     * Sets the ViewListener of this view
     * @param appCreateViewListener the {@link AppointmentCreateViewListener} to set
     */
    void setListener(AppointmentCreateViewListener appCreateViewListener);

    /**
     * Sets the Model of the View
     * @param appointmentBean the appoinmentBean wich will be populated to the screen
     * @param allPatients the list of all available patients
     * @param allApppointmentStates al list of all available appointment states
     */
    void setModel(AppointmentBean appointmentBean, Set<PatientBean> allPatients, Set<AppointmentStateTypeBean> allApppointmentStates);

}
