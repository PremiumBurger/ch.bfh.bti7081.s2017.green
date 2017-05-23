package ch.bfh.bti7081.s2017.green.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue(JournalEntryType.APPOINTMENT)
public class AppointmentJournalEntry extends JournalEntry {

    @ManyToOne
    @JoinColumn(name="appointmentId")
    private Appointment appointment;

    public AppointmentJournalEntry() {
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
