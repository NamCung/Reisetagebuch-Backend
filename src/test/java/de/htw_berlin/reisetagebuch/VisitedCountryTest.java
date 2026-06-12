package de.htw_berlin.reisetagebuch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitedCountryTest {

    @Test
    void toStringReturnsExpectedFormat() {
        VisitedCountry country = new VisitedCountry("Japan", "JP");
        country.setId(1L);
        assertEquals("VisitedCountry{id=1, country='Japan', countryCode='JP'}", country.toString());
    }
}
