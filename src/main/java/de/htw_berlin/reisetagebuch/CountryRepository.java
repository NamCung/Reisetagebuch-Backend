package de.htw_berlin.reisetagebuch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<VisitedCountry, Long> {
    Optional<VisitedCountry> findByCountryCode(String countryCode);
    boolean existsByCountryCode(String countryCode);

    @Transactional
    void deleteByCountryCode(String countryCode);
}