package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.domain.builder.AddressBuilder;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StubAddressServiceImpl implements AddressService {
    @Override
    public Set<AddressBean> getAll() {
        AddressBean bean = new AddressBean();
        bean.setEntity(AddressBuilder.anAddress().rundumSorglos().build());
        return Sets.newHashSet(bean);
    }

    @Override
    public long save(AddressBean bean) {
        return 0;
    }

    @Override
    public void delete(AddressBean bean) {

    }

    @Override
    public AddressBean getOne(long id) {
        AddressBean bean = new AddressBean();
        bean.setEntity(AddressBuilder.anAddress().rundumSorglos().build());
        return bean;
    }
}
