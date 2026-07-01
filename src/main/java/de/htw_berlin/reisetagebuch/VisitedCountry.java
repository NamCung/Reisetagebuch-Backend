package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;

@Entity
public class VisitedCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    // Nicht mehr unique - jeder User kann dasselbe Land haben
    private String countryCode;

    // Email des Besitzers für Datentrennung
    private String besitzer;

    public VisitedCountry() {}

    public VisitedCountry(String country, String countryCode, String besitzer) {
        this.country = country;
        this.countryCode = countryCode;
        this.besitzer = besitzer;
    }

    public Long getId() { return id; }
    public String getCountry() { return country; }
    public String getCountryCode() { return countryCode; }
    public String getBesitzer() { return besitzer; }
    public void setId(Long id) { this.id = id; }
    public void setCountry(String country) { this.country = country; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public void setBesitzer(String besitzer) { this.besitzer = besitzer; }
}