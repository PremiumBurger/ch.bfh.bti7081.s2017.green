package ch.bfh.bti7081.s2017.green.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.time.LocalDate;

// @Entity
// @Inheritance
public class Person extends BaseEntity {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String phone;

    private String mobile;

    private String ahvNr;

    private String email;

    private String gender;

    private Address address;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
