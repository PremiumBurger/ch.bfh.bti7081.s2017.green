package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MyDayViewImpl extends VerticalLayout implements MyDayView {

    MyDayViewListener listener;
    List<AppointmentBean> appointments;
    Accordion accordion = new Accordion();
    ComboBox<AppointmentBean> appointmentSearch;

    public MyDayViewImpl() {
        appointmentSearch = new Autocomplete<AppointmentBean>();
        appointmentSearch.setWidth("100%");
        appointmentSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
            appointmentSearch.setValue(null);
            getUI().getNavigator().navigateTo("Appointment" + "/" + e.getValue().getId());
            }
        });
        addComponents(appointmentSearch, accordion);
    }

    @Override
    public void addListener (MyDayViewListener viewListener) {
        this.listener = viewListener;
    }

    @Override
    public void enter (ViewChangeListener.ViewChangeEvent event) {


    }

    public void init (List<AppointmentBean> appointments) {
        appointmentSearch.setItems(appointments);
        int counter = 1;

        for (AppointmentBean appointment : appointments) {
            FormLayout layout = new FormLayout();
            layout.setId(String.valueOf(appointment.getId()));
            Label time = new Label(appointment.getFrom().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
            time.setIcon(VaadinIcons.CLOCK);
            Label patientname = new Label(appointment.getPatient().getLastName() + " " + appointment.getPatient().getFirstName());
            patientname.setIcon(VaadinIcons.USER);
            Label street = new Label(appointment.getPatient().getAddress().getStrasse());
            street.setIcon(VaadinIcons.HOME);
            Label adr = new Label(appointment.getPatient().getAddress().getPlz() + " " + appointment.getPatient().getAddress().getCity());
            Button details = new Button("Show Details");
            details.setIcon(VaadinIcons.SELECT);
            details.addClickListener(e -> getUI().getNavigator().navigateTo("Appointment" + "/" + appointment.getId()));
            layout.addComponents(time,patientname,street,adr, details);



            accordion.addTab(layout, "Appointment " + counter);
            counter++;
        }


    }


}
