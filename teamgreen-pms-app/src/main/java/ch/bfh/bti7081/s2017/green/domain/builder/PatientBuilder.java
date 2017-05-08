package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.Patient;

import java.time.LocalDate;

public final class PatientBuilder implements RundumSorglosBuilder<PatientBuilder> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String mobile;
    private String ahvNr;
    private String email;
    private String gender;
    private Address address;

    private PatientBuilder() {
    }

    public static PatientBuilder aPatient() {
        return new PatientBuilder();
    }

    public PatientBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PatientBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PatientBuilder withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public PatientBuilder withAhvNr(String ahvNr) {
        this.ahvNr = ahvNr;
        return this;
    }

    public PatientBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PatientBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PatientBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Patient build() {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setBirthDate(birthDate);
        patient.setPhone(phone);
        patient.setMobile(mobile);
        patient.setAhvNr(ahvNr);
        patient.setEmail(email);
        patient.setGender(gender);
        patient.setAddress(address);
        return patient;
    }

    @Override
    public PatientBuilder rundumSorglos() {
        firstName = "Beat";
        lastName = "Orderline";
        birthDate = LocalDate.now();
        phone = "077 777 77 77";
        mobile = "066 666 66 66";
        ahvNr = "super geili ahv nr";
        email = "pidu@orderline.ch";
        gender = "M";
        address = AddressBuilder.anAddress().rundumSorglos().build();
        return this;
    }
}
