package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.AppointmentJournalEntry;
import ch.bfh.bti7081.s2017.green.domain.Person;
import java.time.LocalDateTime;

public class AppointmentJournalEntryBean extends JournalEntryBean {

    private AppointmentBean appointment;

    public AppointmentJournalEntryBean() {
        setEntity(new AppointmentJournalEntry(), false);
    }

    public AppointmentBean getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentBean appointment) {
        this.appointment = appointment;
    }
}
