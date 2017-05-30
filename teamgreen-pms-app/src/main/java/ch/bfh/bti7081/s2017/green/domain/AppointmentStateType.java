package ch.bfh.bti7081.s2017.green.domain;

import ch.bfh.bti7081.s2017.green.domain.Appointment;
import ch.bfh.bti7081.s2017.green.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by S.Schmid on 15.05.2017.
 */
@Entity
public class AppointmentStateType extends BaseEntity {

    private String description;

    @OneToMany(mappedBy = "appointmentStateType")
    private List<Appointment> appointments;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
