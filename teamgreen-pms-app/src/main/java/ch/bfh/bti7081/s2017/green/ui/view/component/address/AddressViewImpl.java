package ch.bfh.bti7081.s2017.green.ui.view.component.address;

import ch.bfh.bti7081.s2017.green.ui.view.main.MainViewImpl;
import com.vaadin.ui.Button;

/**
 * Created by joris on 09.05.17.
 */
public class AddressViewImpl extends MainViewImpl implements AddressView {
    public AddressViewImpl() {

        Button testButton = new Button();


        super.setViewContent(testButton);
    }
}
