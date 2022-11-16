package co.greedycode.GraphqlAdapter.repository;

import co.greedycode.GraphqlAdapter.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<Log, Long> {
}
