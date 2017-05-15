package ch.bfh.bti7081.s2017.green.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Holds all properties of a Person.
 * <p>
 * Must not be abstract because of ModelMapper.
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "personType")
public class Person extends BaseEntity {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String phone;

    private String mobile;

    private String ahvNr;

    private String email;

    public Person() {
        // empty constructor
    }

    @OneToOne
    @JoinColumn(name = "addressId")
    @Cascade(CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "genderTypeId")
    private GenderType genderType;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAhvNr() {
        return ahvNr;
    }

    public void setAhvNr(String ahvNr) {
        this.ahvNr = ahvNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

}
