package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Person;

import java.time.LocalDate;

public class PersonBean extends EntityBean<Person> {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String phone;

    private String mobile;

    private String ahvNr;

    private String email;

    private String gender;

    private AddressBean AddressBean;

    public AddressBean getAddressBean() {
        return AddressBean;
    }

    public void setAddressBean(AddressBean AddressBean) {
        this.AddressBean = AddressBean;
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
