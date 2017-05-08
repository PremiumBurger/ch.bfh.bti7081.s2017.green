package ch.bfh.bti7081.s2017.green.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

// @Entity
// @Inheritance
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }
}
