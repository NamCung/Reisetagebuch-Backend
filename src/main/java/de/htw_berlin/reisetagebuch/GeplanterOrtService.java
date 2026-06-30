package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeplanterOrtService {

    @Autowired
    GeplanterOrtRepository repo;

    public GeplanterOrt save(GeplanterOrt ort) {
        return repo.save(ort);
    }

    public GeplanterOrt get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<GeplanterOrt> getByReise(Long reiseId) {
        return repo.findByReiseId(reiseId);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}