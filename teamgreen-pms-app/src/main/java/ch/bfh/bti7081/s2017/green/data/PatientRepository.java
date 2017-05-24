package ch.bfh.bti7081.s2017.green.data;

import ch.bfh.bti7081.s2017.green.domain.Patient;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    Set<Patient> findByFirstNameStartsWithIgnoreCase(String lastName);
    Set<Patient> findByLastNameStartsWithIgnoreCase(String firstName);
    //return anyway a table with all attributes concatinated
}
