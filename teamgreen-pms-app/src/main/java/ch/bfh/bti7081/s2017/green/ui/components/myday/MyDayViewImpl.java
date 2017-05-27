package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;
import ch.bfh.bti7081.s2017.green.ui.MainUI;
import ch.bfh.bti7081.s2017.green.ui.MasterPageImpl;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MyDayViewImpl extends MasterPageImpl implements MyDayView {

    MyDayViewListener listener;
    List<AppointmentBean> appointments;
    Accordion accordion = new Accordion();

    public MyDayViewImpl() {
        setViewContent(accordion);
    }

    @Override
    public void addListener(MyDayViewListener viewListener) {
        this.listener = viewListener;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public void init(List<AppointmentBean> appointments){
        int counter = 1;

        for (AppointmentBean appointment : appointments){
            FormLayout layout = new FormLayout();
            Label time = new Label(appointment.getFrom().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
            time.setIcon(VaadinIcons.CLOCK);
            Label patientname = new Label(appointment.getPatient().getLastName() + " " + appointment.getPatient().getFirstName());
            patientname.setIcon(VaadinIcons.USER);
            Label street = new Label(appointment.getPatient().getAddress().getStrasse());
            street.setIcon(VaadinIcons.HOME);
            Label adr = new Label(appointment.getPatient().getAddress().getPlz() + " " + appointment.getPatient().getAddress().getCity());

            layout.addComponents(time,patientname,street,adr);

            layout.addLayoutClickListener(l -> MainUI.navigator.navigateTo("appointmentview"));

            accordion.addTab(layout, "Appointment " + counter);
            counter++;
        }


    }


}
