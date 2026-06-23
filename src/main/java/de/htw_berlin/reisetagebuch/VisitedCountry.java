package de.htw_berlin.reisetagebuch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VisitedCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String country;
    String countryCode;         // ISO Code für Länder JP- Japan

    public VisitedCountry() {}

    public VisitedCountry(String country, String countryCode) {
        this.country = country;
        this.countryCode = countryCode;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    @Override
    public String toString() {
        return "VisitedCountry{id=" + id + ", country='" + country + "', countryCode='" + countryCode + "'}";
    }}


