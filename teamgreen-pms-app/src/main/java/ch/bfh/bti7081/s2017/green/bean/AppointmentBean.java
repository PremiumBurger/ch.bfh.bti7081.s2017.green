package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.ui.components.autcomplete.Autocompletable;
import org.apache.commons.codec.binary.StringUtils;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentBean extends EntityBean<Appointment> implements Autocompletable{

    @NotNull
    private LocalDateTime from;

    @NotNull
    private LocalDateTime to;

    @NotNull
    private HealthVisitorBean healthVisitor;

    @NotNull
    private PatientBean patient;

    @NotNull
    private AppointmentStateTypeBean appointmentStateType;

    private AddressBean address;

    public AppointmentBean() {
        setEntity(new Appointment(), true);
        address = new AddressBean();
    }

    public HealthVisitorBean getHealthVisitor() {
        return healthVisitor;
    }

    public void setHealthVisitor(HealthVisitorBean healthVisitor) {
        this.healthVisitor = healthVisitor;
    }

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public AppointmentStateTypeBean getAppointmentStateType() {
        return appointmentStateType;
    }

    public void setAppointmentStateType(AppointmentStateTypeBean appointmentStateType) {
        this.appointmentStateType = appointmentStateType;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    @Override
    public String getSearchString() {
        return getPatient().getFirstName() + " " + getPatient().getLastName() +  " " + "From: " + getFrom() + " " + "To: " + getTo();
    }

    public String getAddressString() {
        if (address != null) {
            return address.getDisplayString();
        }
        return null;
    }
}
