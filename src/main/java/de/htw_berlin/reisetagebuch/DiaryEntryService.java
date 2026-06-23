package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiaryEntryService {

    @Autowired
    DiaryEntryRepository repo;

    public DiaryEntry save(DiaryEntry entry) {
        return repo.save(entry);
    }

    public DiaryEntry get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<DiaryEntry> getByReise(Long reiseId) {
        return repo.findByReiseId(reiseId);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}