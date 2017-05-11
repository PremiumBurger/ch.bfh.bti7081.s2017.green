package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;

import java.time.LocalDate;

public final class HealthVisitorBuilder implements RundumSorglosBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String mobile;
    private String ahvNr;
    private String email;
    private Address address;

    private HealthVisitorBuilder() {
    }

    public static HealthVisitorBuilder aHealthVisitor() {
        return new HealthVisitorBuilder();
    }

    public HealthVisitorBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public HealthVisitorBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public HealthVisitorBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public HealthVisitorBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public HealthVisitorBuilder withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public HealthVisitorBuilder withAhvNr(String ahvNr) {
        this.ahvNr = ahvNr;
        return this;
    }

    public HealthVisitorBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public HealthVisitorBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public HealthVisitor build() {
        HealthVisitor healthVisitor = new HealthVisitor();
        healthVisitor.setFirstName(firstName);
        healthVisitor.setLastName(lastName);
        healthVisitor.setBirthDate(birthDate);
        healthVisitor.setPhone(phone);
        healthVisitor.setMobile(mobile);
        healthVisitor.setAhvNr(ahvNr);
        healthVisitor.setEmail(email);
        healthVisitor.setAddress(address);
        return healthVisitor;
    }

    @Override
    public HealthVisitorBuilder rundumSorglos() {
        firstName = "Sabine";
        lastName = "Pitex";
        birthDate = LocalDate.now();
        phone = "077 777 77 77";
        mobile = "066 666 66 66";
        ahvNr = "super geili ahv nr";
        email = "sabi@pitex.ch";
        address = AddressBuilder.anAddress().rundumSorglos().build();
        return this;
    }
}
