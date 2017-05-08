package ch.bfh.bti7081.s2017.green.data;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import org.springframework.stereotype.Repository;

import java.util.Set;

// @Repository
public interface HealthVisitorRepository {
    Set<HealthVisitor> findByLastNameStartsWithIgnoreCase(String lastName);
}
