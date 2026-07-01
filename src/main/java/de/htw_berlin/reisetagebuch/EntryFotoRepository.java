package de.htw_berlin.reisetagebuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EntryFotoRepository extends CrudRepository<EntryFoto, Long> {
    List<EntryFoto> findByEntryId(Long entryId);
}