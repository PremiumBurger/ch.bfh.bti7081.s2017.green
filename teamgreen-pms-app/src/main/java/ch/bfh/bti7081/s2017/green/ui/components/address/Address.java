package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Address {

    private AddressService service;

    @Autowired
    public Address(AddressService service) {
        this.service = service;
    }

    public Set<AddressBean> getAddressList() {
        return service.getAll();
    }
}
