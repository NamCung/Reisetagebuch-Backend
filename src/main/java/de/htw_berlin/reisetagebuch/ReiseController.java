package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReiseController {

    @Autowired
    CountryService service;

    @CrossOrigin
    @GetMapping("/countries")
    public List<VisitedCountry> getAllCountries() {
        return service.getAll();
    }

    @CrossOrigin
    @PostMapping("/countries")
    public VisitedCountry addCountry(@RequestBody VisitedCountry country) {
        return service.save(country);
    }
}
