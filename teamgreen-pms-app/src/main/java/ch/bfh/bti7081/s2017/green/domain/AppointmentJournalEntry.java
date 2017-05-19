package ch.bfh.bti7081.s2017.green.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(JournalEntryType.APPOINTMENT)
public class AppointmentJournalEntry {

    //Todo: Annotation

    private Appointment appointment;

    public AppointmentJournalEntry(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
