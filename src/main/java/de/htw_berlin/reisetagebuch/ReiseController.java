package de.htw_berlin.reisetagebuch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://reisetagebuch-frontend-1.onrender.com")
public class ReiseController {
    @GetMapping("/countries")
    public List<VisitedCountry> getAllCountries() {
        return List.of(
                new VisitedCountry("Deutschland", "DE"),
                new VisitedCountry("Frankreich", "FR"),
                new VisitedCountry("Japan", "JP"),
                new VisitedCountry("USA", "US"),
                new VisitedCountry("Australien", "AU")          // Kommentar Test
        );
    }
}
