package de.htw_berlin.reisetagebuch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<VisitedCountry, Long> {

    // Alte Methoden
    Optional<VisitedCountry> findByCountryCode(String countryCode);
    boolean existsByCountryCode(String countryCode);

    @Transactional
    void deleteByCountryCode(String countryCode);

    // Neue Methoden für Datentrennung
    List<VisitedCountry> findByBesitzer(String besitzer);
    Optional<VisitedCountry> findByCountryCodeAndBesitzer(String countryCode, String besitzer);
    boolean existsByCountryCodeAndBesitzer(String countryCode, String besitzer);

    @Transactional
    void deleteByCountryCodeAndBesitzer(String countryCode, String besitzer);
}