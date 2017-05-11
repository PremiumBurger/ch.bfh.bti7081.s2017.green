package ch.bfh.bti7081.s2017.green.ui.components.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressViewPresenter implements AddressViewListener {

    private Address address;

    private AddressView addressView;

    @Autowired
    public AddressViewPresenter(AddressView addressView, Address address) {
        this.addressView = addressView;
        this.address = address;
        addressView.addListener(this);
    }

    @Override
    public void onButtonClick() {
        addressView.doSomething(address.getAddressList());
    }

}
