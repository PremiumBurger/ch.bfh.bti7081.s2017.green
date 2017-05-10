package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.service.AddressService;

import java.util.Set;

/**
 * Created by Simu on 10.05.2017 for Project ch.bfh.bti7081.s2017.green.
 */

public class Address {
    private AddressService service;

    public Address(AddressService service) {
        this.service = service;
    }

    public Set<AddressBean> getAddressList() {
        return service.getAll();
    }
}
