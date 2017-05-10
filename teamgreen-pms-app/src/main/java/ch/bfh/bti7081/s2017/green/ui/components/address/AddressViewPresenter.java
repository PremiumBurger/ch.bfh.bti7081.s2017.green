package ch.bfh.bti7081.s2017.green.ui.components.address;

/**
 * Created by Simu on 10.05.2017 for Project ch.bfh.bti7081.s2017.green.
 * TEstbeschreibung
 */

public class AddressViewPresenter implements AddressViewListener {
    private Address address;
    private AddressView addressView;

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
