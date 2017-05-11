package ch.bfh.bti7081.s2017.green.ui.components.address;

/**
 * Handles the interaction between View and Model
 * @author schms27
 */
public class AddressViewPresenter implements AddressViewListener {
    private Address address;                //Model
    private AddressView addressView;        //View

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
