package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;

import java.util.Set;

public interface HealthVisitorService {

    Set<HealthVisitor> getAll();

    HealthVisitor getOne(long healthVisitorId);

    Set<HealthVisitor> find(String lastName);

    long save(HealthVisitor healthVisitor);

    void delete(HealthVisitor healthVisitor);

}
