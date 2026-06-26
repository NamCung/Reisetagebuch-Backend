package de.htw_berlin.reisetagebuch;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repo;

    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    public List<VisitedCountry> getAll() {
        return repo.findAll();
    }

    public VisitedCountry add(String country, String countryCode) {
        if (countryCode == null || countryCode.isBlank() || countryCode.equals("-99")) {
            throw new IllegalArgumentException("Ungültiger countryCode: " + countryCode + " (" + country + ")");
        }
        if (repo.existsByCountryCode(countryCode))
            return repo.findByCountryCode(countryCode).get();
        return repo.save(new VisitedCountry(country, countryCode));
    }

    @Transactional
    public void delete(String countryCode) {
        repo.deleteByCountryCode(countryCode);
    }
}