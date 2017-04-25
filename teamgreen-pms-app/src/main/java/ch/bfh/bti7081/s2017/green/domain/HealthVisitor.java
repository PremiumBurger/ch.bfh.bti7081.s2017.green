package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HealthVisitor {

    @Id
    @GeneratedValue
    private Long healthVisitorId;

    private String firstName;

    private String lastName;

    public HealthVisitor() {

    }

    public HealthVisitor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getHealthVisitorId() {
        return healthVisitorId;
    }

    public void setHealthVisitorId(Long healthVisitorId) {
        this.healthVisitorId = healthVisitorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "HealthVisitor{" +
                "healthVisitorId=" + healthVisitorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
