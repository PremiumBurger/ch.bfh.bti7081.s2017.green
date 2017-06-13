package ch.bfh.bti7081.s2017.green.ui.components.PatientDetail;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import com.vaadin.navigator.View;

import java.util.List;
import java.util.Set;

/**
 * Created by mathewthekkekara on 06.06.17.
 */
public interface PatientDetailView extends View {

    /**
     * Sets the ViewListener of this view
     * @param patientDetailViewListener the {@link PatientDetailViewListener} to set
     */
    public void addListener(PatientDetailViewListener patientDetailViewListener);

    /**
     * Sets the Model of the View
     * @param patientBean the patientBean which will be populated to the screen
     * @param apointments the list of all appointments with the Patient
     */
    public void setModel(PatientBean patientBean, List<AppointmentBean> apointments);
}
