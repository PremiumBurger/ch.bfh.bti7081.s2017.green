package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.data.AddressRepository;
import ch.bfh.bti7081.s2017.green.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl extends BaseService<Address, AddressBean, AddressRepository> implements AddressService {

    private AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    protected Class<AddressBean> getType() {
        return AddressBean.class;
    }
}
