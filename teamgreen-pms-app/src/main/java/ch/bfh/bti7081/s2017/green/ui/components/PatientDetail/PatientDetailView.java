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

    public void addListener(PatientDetailViewListener listener);

    public void init(PatientBean patient);

    public void setModel(PatientBean patientBean, List<AppointmentBean> apointments);
}
