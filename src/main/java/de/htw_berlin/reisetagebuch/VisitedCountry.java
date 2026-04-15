package de.htw_berlin.reisetagebuch;

public class VisitedCountry {
    String country;
    String countryCode;         // ISO Code für Länder JP- Japan


    public VisitedCountry(){}

    public VisitedCountry(String country, String countryCode) {

        this.country = country;
        this.countryCode = countryCode;

    }


    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }}




