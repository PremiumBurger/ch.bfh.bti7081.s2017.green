package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Person;

import java.time.LocalDate;

public final class PersonBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String mobile;
    private String ahvNr;
    private String email;
    private String gender;
    private Address address;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public PersonBuilder withAhvNr(String ahvNr) {
        this.ahvNr = ahvNr;
        return this;
    }

    public PersonBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthDate(birthDate);
        person.setPhone(phone);
        person.setMobile(mobile);
        person.setAhvNr(ahvNr);
        person.setEmail(email);
        person.setGender(gender);
        person.setAddress(address);
        return person;
    }
}
