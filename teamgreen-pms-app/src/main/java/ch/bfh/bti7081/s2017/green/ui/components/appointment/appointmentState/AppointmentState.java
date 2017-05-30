package ch.bfh.bti7081.s2017.green.ui.components.appointment.appointmentState;

/**
 * Appointment State Class to extend from to create new Appointment States
 * @author schms27
 */
public abstract class AppointmentState implements AppointmentStateEventHandler {
    private String description;

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

}
