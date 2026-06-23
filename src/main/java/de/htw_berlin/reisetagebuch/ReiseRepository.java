package de.htw_berlin.reisetagebuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReiseRepository extends CrudRepository<Reise, Long> {
}