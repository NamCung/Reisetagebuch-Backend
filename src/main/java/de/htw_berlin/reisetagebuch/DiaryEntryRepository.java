package de.htw_berlin.reisetagebuch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiaryEntryRepository extends CrudRepository<DiaryEntry, Long> {
    List<DiaryEntry> findByReiseId(Long reiseId); // alle Einträge einer Reise
}