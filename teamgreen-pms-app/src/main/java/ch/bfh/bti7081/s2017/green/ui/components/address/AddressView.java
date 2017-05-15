package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import com.vaadin.navigator.View;

import java.util.Set;

public interface AddressView extends View{
    void addListener(AddressViewListener listener);

    void doSomething(Set<AddressBean> addressBeanSet);
}
