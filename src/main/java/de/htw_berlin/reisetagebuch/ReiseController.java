package de.htw_berlin.reisetagebuch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReiseController {
    @GetMapping("/countries")
    public List<VisitedCountry> getAllCountries() {
        return List.of(
                new VisitedCountry("Deutschland", "DE"),
                new VisitedCountry("Frankreich", "FR"),
                new VisitedCountry("Japan", "JP"),
                new VisitedCountry("USA", "US"),
                new VisitedCountry("Australien", "AU")
        );
    }
}
