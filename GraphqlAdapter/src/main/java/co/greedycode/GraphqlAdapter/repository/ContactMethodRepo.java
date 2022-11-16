package co.greedycode.GraphqlAdapter.repository;

import co.greedycode.GraphqlAdapter.entities.ContactMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactMethodRepo extends JpaRepository<ContactMethod, Long> {
    Optional<ContactMethod> findByPersonId(Long id);
}
