package co.greedycode.GraphqlAdapter.repository;

import co.greedycode.GraphqlAdapter.entities.CoreBioGraphics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoreBioGraphicsRepo extends JpaRepository<CoreBioGraphics, Long> {

    Optional<CoreBioGraphics> findByPersonId(Long id);
}
