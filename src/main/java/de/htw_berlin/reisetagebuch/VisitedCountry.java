package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;

@Entity
public class VisitedCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    @Column(unique = true, nullable = false)
    private String countryCode;

    public VisitedCountry() {}

    public VisitedCountry(String country, String countryCode) {
        this.country = country;
        this.countryCode = countryCode;
    }

    public Long getId() { return id; }
    public String getCountry() { return country; }
    public String getCountryCode() { return countryCode; }
    public void setId(Long id) { this.id = id; }
    public void setCountry(String country) { this.country = country; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
}