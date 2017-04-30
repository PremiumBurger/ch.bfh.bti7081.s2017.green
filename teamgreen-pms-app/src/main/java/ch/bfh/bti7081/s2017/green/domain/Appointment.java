package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;

@Entity
public class Appointment extends BaseEntity {

    private HealthVisitor healthVisitor;

    private Patient patient;


}
