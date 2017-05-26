package ch.bfh.bti7081.s2017.green.ui.components.appointment;

import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.bean.PatientBean;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by joris on 26.05.17.
 */
@Component
public class AppointmentViewImpl extends MasterPageImpl implements AppointmentView {
    private DateTimeField from;
    private DateTimeField to;
    private ComboBox<PatientBean> comboBox;
    private Button save;
    public AppointmentViewImpl() {;
        FormLayout layout = new FormLayout();

        from = new DateTimeField();
        to = new DateTimeField();
        comboBox = new ComboBox<>();
        save = new Button("Save");
        save.setIcon(VaadinIcons.SAFE);
        layout.addComponents(from,to,comboBox,save);
        setViewContent(layout);


    }

    @Override
    public void addListener(AppointmentViewListener appointmentViewListener) {

    }

    @Override
    public void init(AppointmentBean appointment, List<PatientBean> patients) {
        from.setCaption("Von");
        from.setValue(appointment.getFrom());
        to.setCaption("Bis");
        to.setValue(appointment.getTo());




    }

    @Override
    public void saveChanges() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {


    }
}
