package ch.bfh.bti7081.s2017.green.service;

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
    public Set<HealthVisitor> getAll() {
        return Sets.newHashSet(healthVisitorRepository.findAll());
    }

    @Override
    public long save(HealthVisitor healthVisitor) {
        HealthVisitor saved = healthVisitorRepository.save(healthVisitor);
        return saved.getHealthVisitorId();
    }

    @Override
    public void delete(HealthVisitor healthVisitor) {
        healthVisitorRepository.delete(healthVisitor);
    }

    @Override
    public HealthVisitor getOne(long healthVisitorId) {
        return healthVisitorRepository.findOne(healthVisitorId);
    }

    @Override
    public Set<HealthVisitor> find(String lastName) {
        return Sets.newHashSet(healthVisitorRepository.findByLastNameStartsWithIgnoreCase(lastName));
    }
}
