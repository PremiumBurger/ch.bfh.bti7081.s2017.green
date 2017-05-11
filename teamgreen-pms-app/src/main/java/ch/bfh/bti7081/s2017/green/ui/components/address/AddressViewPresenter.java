package ch.bfh.bti7081.s2017.green.ui.components.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handles the interaction between View and Model
 * @author schms27
 */
@Component
public class AddressViewPresenter implements AddressViewListener {
    private Address address;                //Model
    private AddressView addressView;        //View

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
