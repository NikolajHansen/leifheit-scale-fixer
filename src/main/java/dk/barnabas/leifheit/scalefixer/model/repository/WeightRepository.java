package dk.barnabas.leifheit.scalefixer.model.repository;

import dk.barnabas.leifheit.scalefixer.model.jpa.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
}
