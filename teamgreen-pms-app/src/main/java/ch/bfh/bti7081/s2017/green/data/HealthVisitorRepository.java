package ch.bfh.bti7081.s2017.green.data;

import ch.bfh.bti7081.s2017.green.domain.HealthVisitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthVisitorRepository extends CrudRepository<HealthVisitor, Long> {

    List<HealthVisitor> findByLastNameStartsWithIgnoreCase(String lastName);

}
