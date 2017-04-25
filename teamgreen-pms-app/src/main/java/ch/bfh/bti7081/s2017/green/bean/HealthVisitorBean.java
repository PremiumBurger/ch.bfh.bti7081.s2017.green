package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HealthVisitorBean extends EntityBean<HealthVisitor> {

    private Long healthVisitorId;

    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;

    public HealthVisitorBean() {
        setEntity(new HealthVisitor());
    }

    public HealthVisitorBean(HealthVisitor entity) {
        setEntity(entity);
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
}
