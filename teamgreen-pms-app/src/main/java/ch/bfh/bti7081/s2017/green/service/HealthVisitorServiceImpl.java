package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.HealthVisitorBean;
import ch.bfh.bti7081.s2017.green.data.HealthVisitorRepository;
import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HealthVisitorServiceImpl implements HealthVisitorService {

    @Autowired
    private HealthVisitorRepository healthVisitorRepository;

    @Override
    public Set<HealthVisitorBean> getAll() {
        Set<HealthVisitorBean> result = Sets.newHashSet();
        healthVisitorRepository.findAll().forEach(hv -> result.add(new HealthVisitorBean(hv)));
        return result;
    }

    @Override
    public long save(HealthVisitorBean healthVisitor) {
        HealthVisitor saved = healthVisitorRepository.save(healthVisitor.updateEntiy());
        return saved.getHealthVisitorId();
    }

    @Override
    public void delete(HealthVisitorBean healthVisitor) {
        healthVisitorRepository.delete(healthVisitor.getHealthVisitorId());
    }

    @Override
    public HealthVisitorBean getOne(long healthVisitorId) {
        HealthVisitor hv = healthVisitorRepository.findOne(healthVisitorId);
        if (hv != null) {
            return new HealthVisitorBean(hv);
        }
        return null;
    }

    @Override
    public Set<HealthVisitorBean> find(String lastName) {
        Set<HealthVisitorBean> result = Sets.newHashSet();
        healthVisitorRepository.findByLastNameStartsWithIgnoreCase(lastName).forEach(hv -> result.add(new HealthVisitorBean(hv)));
        return result;
    }
}
