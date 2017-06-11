package ch.bfh.bti7081.s2017.green.ui.components.myday;


import ch.bfh.bti7081.s2017.green.bean.AppointmentBean;

import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocomplete;

import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;
import org.vaadin.addons.stackpanel.StackPanel;


import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MyDayViewImpl extends VerticalLayout implements MyDayView {

    MyDayViewListener listener;
    List<AppointmentBean> appointments;

    ComboBox<AppointmentBean> appointmentSearch;

    public MyDayViewImpl() {
        setSpacing(false);
        appointmentSearch = new Autocomplete<AppointmentBean>();
        appointmentSearch.setWidth("100%");
        appointmentSearch.addValueChangeListener(e -> {
            if(e.getValue() != null) {
            appointmentSearch.setValue(null);
            getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + e.getValue().getId());
            }
        });

    }

    @Override
    public void addListener (MyDayViewListener viewListener) {
        this.listener = viewListener;
    }

    @Override
    public void enter (ViewChangeListener.ViewChangeEvent event) {
        listener.getData();


    }

    public void init (List<AppointmentBean> appointments) {
        appointmentSearch.setItems(appointments);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(PmsConstants.SWISS_DATE_FORMAT);

        this.removeAllComponents();
        addComponent(appointmentSearch);
        // add button bar
        addComponent(buildButtonbar());
        for (AppointmentBean appointment : appointments) {

            FormLayout layout = new FormLayout();
            layout.setId(String.valueOf(appointment.getId()));
            Label to = new Label(appointment.getTo().format(format));
            to.setCaption("To");
            to.setIcon(VaadinIcons.CLOCK);
            Label patientname = new Label(appointment.getPatient().getFullName());
            patientname.setCaption("Name");
            patientname.setIcon(VaadinIcons.USER);
            Label street = new Label(appointment.getPatient().getAddress().getStrasse());
            street.setIcon(VaadinIcons.HOME);
            street.setCaption("Address");
            Label adr = new Label(appointment.getPatient().getAddress().getPlz() + " " + appointment.getPatient().getAddress().getCity());
            Button details = new Button("Show Details");
            details.setIcon(VaadinIcons.CLIPBOARD_PULSE);
            details.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentDetail" + "/" + appointment.getId()));


            layout.addComponents(to,patientname,street,adr,details);

            Panel contentPanel = new Panel(" Appointment from: " + appointment.getFrom().format(format) + " Patient: " + appointment.getPatient().getFullName());
            contentPanel.setContent(layout);
            contentPanel.setIcon(VaadinIcons.CLOCK);
            layout.setMargin(true);
            layout.setSpacing(false);

            StackPanel stackPanel =  StackPanel.extend(contentPanel);
            addComponent(contentPanel);

        }

    }

    private HorizontalLayout buildButtonbar() {

        HorizontalLayout buttonBarLayout = new HorizontalLayout();
        buttonBarLayout.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
        buttonBarLayout.setWidth(100, Unit.PERCENTAGE);
        HorizontalLayout buttons = new HorizontalLayout();
        buttonBarLayout.addComponent(buttons);

        // buttons
        Button create = new Button("Create new Appointment");
        buttons.addComponents(create);

        //listener
        create.addClickListener(e -> getUI().getNavigator().navigateTo("AppointmentCreate" + "/" + 1));

        // styles
        create.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        create.setIcon(VaadinIcons.CALENDAR_USER);
        buttonBarLayout.setResponsive(true);

        return buttonBarLayout;
    }


}
