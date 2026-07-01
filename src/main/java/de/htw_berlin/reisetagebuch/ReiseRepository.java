package de.htw_berlin.reisetagebuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReiseRepository extends CrudRepository<Reise, Long> {
    // Reisen nach Besitzer filtern
    List<Reise> findByBesitzer(String besitzer);
}