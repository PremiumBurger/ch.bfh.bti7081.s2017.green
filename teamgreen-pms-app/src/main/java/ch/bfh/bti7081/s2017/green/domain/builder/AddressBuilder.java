package ch.bfh.bti7081.s2017.green.domain.builder;

import ch.bfh.bti7081.s2017.green.domain.Address;

public final class AddressBuilder implements RundumSorglosBuilder<AddressBuilder> {
    private String strasse;
    private String plz;
    private String city;
    private String country;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withStrasse(String strasse) {
        this.strasse = strasse;
        return this;
    }

    public AddressBuilder withPlz(String plz) {
        this.plz = plz;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setStrasse(strasse);
        address.setPlz(plz);
        address.setCity(city);
        address.setCountry(country);
        return address;
    }

    @Override
    public AddressBuilder rundumSorglos() {
        strasse = "Superstrasse 22";
        plz = "3400";
        city = "Burgdorf";
        country = "Schweiz";
        return this;
    }
}
