package co.greedycode.GraphqlAdapter.repository;

import co.greedycode.GraphqlAdapter.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
    Optional<Person> findByEmailAndPassword(String Email, String password);
}
