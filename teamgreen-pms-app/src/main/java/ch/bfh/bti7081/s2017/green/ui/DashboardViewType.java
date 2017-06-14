package ch.bfh.bti7081.s2017.green.ui;

import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentCreate.AppointmentCreateView;
import ch.bfh.bti7081.s2017.green.ui.components.PatientDetail.PatientDetailView;
import ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentDetail.AppointmentDetailView;
import ch.bfh.bti7081.s2017.green.ui.components.journal.JournalView;
import ch.bfh.bti7081.s2017.green.ui.components.myday.MyDayView;
import ch.bfh.bti7081.s2017.green.ui.components.patients.PatientView;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;

public enum DashboardViewType {
    MYDAY("MyDay", MyDayView.class, VaadinIcons.HOME, false, true),
    JOURNAL("Journal", JournalView.class, VaadinIcons.CALENDAR, false, false),
    APPOINTMENT_DETAIL("AppointmentDetail", AppointmentDetailView.class, VaadinIcons.CALENDAR, false, false),
    APPOINTMENT_CREATE("AppointmentCreate", AppointmentCreateView.class, VaadinIcons.CALENDAR, false, false),
    PATIENT("Patients", PatientView.class, VaadinIcons.USER, false, true),
    PATIENTDETAIL("patientDetail",PatientDetailView.class, VaadinIcons.USER,false,false);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;
    private final boolean visible;

    DashboardViewType(final String viewName, final Class<? extends View> viewClass, final Resource icon, final boolean stateful, final boolean visible) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
        this.visible = visible;
    }

    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public boolean showInMainNavigation () {
        return visible;
    }
}

