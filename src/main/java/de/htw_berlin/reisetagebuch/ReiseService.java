package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReiseService {

    @Autowired
    ReiseRepository repo;

    public Reise save(Reise reise) {
        return repo.save(reise);
    }

    public Reise get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Reise> getAll() {
        List<Reise> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}