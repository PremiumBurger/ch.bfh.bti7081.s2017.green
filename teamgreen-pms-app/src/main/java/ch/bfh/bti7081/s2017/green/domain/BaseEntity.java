package ch.bfh.bti7081.s2017.green.domain;


import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }
}
