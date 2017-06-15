package ch.bfh.bti7081.s2017.green.bean;

import ch.bfh.bti7081.s2017.green.domain.Address;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressBean extends EntityBean<Address> {

    @NotNull
    private String strasse;

    @NotNull
    @Size(min = 4, max = 6)
    private String plz;

    @NotNull
    private String city;

    private String country;

    public AddressBean() {
        setEntity(new Address(), false);
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplayString() {
        return strasse + ", " + plz + " " + city;
    }
}
