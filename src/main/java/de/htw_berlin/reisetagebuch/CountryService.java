package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class
CountryService {

    @Autowired
    CountryRepository repo;

    public VisitedCountry save(VisitedCountry country) {
        return repo.save(country);
    }

    public VisitedCountry get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<VisitedCountry> getAll() {
        List<VisitedCountry> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }
}
