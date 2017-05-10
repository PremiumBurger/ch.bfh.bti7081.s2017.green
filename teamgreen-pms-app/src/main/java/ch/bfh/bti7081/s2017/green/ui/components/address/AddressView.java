package ch.bfh.bti7081.s2017.green.ui.components.address;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;

import java.util.Set;

/**
 * Created by joris on 09.05.17.
 */
public interface AddressView {
    void addListener(AddressViewListener listener);

    void doSomething(Set<AddressBean> addressBeanSet);
}
