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

    // Nur Länder des eingeloggten Users zurückgeben
    public List<VisitedCountry> getByBesitzer(String email) {
        return repo.findByBesitzer(email);
    }

    public VisitedCountry add(String country, String countryCode, String email) {
        if (countryCode == null || countryCode.isBlank() || countryCode.equals("-99")) {
            throw new IllegalArgumentException("Ungültiger countryCode: " + countryCode + " (" + country + ")");
        }
        // Prüfen ob dieser User das Land schon hat
        if (repo.existsByCountryCodeAndBesitzer(countryCode, email)) {
            return repo.findByCountryCodeAndBesitzer(countryCode, email).get();
        }
        return repo.save(new VisitedCountry(country, countryCode, email));
    }

    @Transactional
    public void deleteByCodeAndBesitzer(String countryCode, String email) {
        repo.deleteByCountryCodeAndBesitzer(countryCode, email);
    }
}