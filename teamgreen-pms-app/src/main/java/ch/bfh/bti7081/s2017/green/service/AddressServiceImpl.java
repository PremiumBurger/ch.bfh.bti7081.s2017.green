package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.data.AddressRepository;
import ch.bfh.bti7081.s2017.green.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseService<Address, AddressBean, AddressRepository> implements AddressService {

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }

    @Override
    protected Class<AddressBean> getType() {
        return AddressBean.class;
    }
}
