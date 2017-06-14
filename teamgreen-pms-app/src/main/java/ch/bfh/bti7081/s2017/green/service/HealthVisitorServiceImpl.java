package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.data.HealthVisitorRepository;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import ch.bfh.bti7081.s2017.green.event.UserLoginRequestedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
public class HealthVisitorServiceImpl extends BaseService<HealthVisitor, HealthVisitorBean, HealthVisitorRepository> implements HealthVisitorService {


    @Autowired
    public HealthVisitorServiceImpl(HealthVisitorRepository repository) {
        super(repository);
    }

    @Override
    protected Class<HealthVisitorBean> getType() {
        return HealthVisitorBean.class;
    }

    @Override
    public Set<HealthVisitorBean> find(String lastName) {
        return find((r) -> r.findByLastNameStartsWithIgnoreCase(lastName));
    }

    @Override
    public HealthVisitorBean get (String externlaKey) {
        Set<HealthVisitorBean> visitors = this.find(r -> r.findByExternalKeyStartsWithIgnoreCase(externlaKey));
        Iterator<HealthVisitorBean> iterator = visitors.iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }

    @Override
    public HealthVisitorBean createFromUserContext (UserLoginRequestedEvent loginRequest) {
        HealthVisitorBean visitor = new HealthVisitorBean();
        visitor.setFirstName(loginRequest.getFirstName());
        visitor.setLastName(loginRequest.getLastName());
        visitor.setExternalKey(loginRequest.getIdentifier());

        save(visitor);

        return visitor;
    }
}
