package de.htw_berlin.reisetagebuch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    CountryService service;

    @MockitoBean
    CountryRepository repo;

    @Test
    void getReturnsCorrectCountry() {
        VisitedCountry country = new VisitedCountry("Japan", "JP");
        country.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(country));

        VisitedCountry result = service.get(1L);

        assertEquals("Japan", result.getCountry());
        assertEquals("JP", result.getCountryCode());
    }
}
