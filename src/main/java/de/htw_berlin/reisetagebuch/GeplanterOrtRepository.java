package de.htw_berlin.reisetagebuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GeplanterOrtRepository extends CrudRepository<GeplanterOrt, Long> {
    List<GeplanterOrt> findByReiseId(Long reiseId); // alle geplanten Orte einer Reise
}