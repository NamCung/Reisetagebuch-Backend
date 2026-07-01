package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://reisetagebuch-frontend.onrender.com",
        "https://reisetagebuch-frontend-1.onrender.com"
})
public class ReiseController {

    @Autowired
    CountryService service;

    @Autowired
    ReiseService reiseService;

    @Autowired
    DiaryEntryService diaryEntryService;

    @Autowired
    GeplanterOrtService geplanterOrtService;

    @Autowired
    EntryFotoService fotoService;

    // ── Countries ────────────────────────────────

    // Email als Parameter - nur Länder des eingeloggten Users
    @GetMapping("/countries/visited")
    public List<VisitedCountry> getAllCountries(@RequestParam String email) {
        return service.getByBesitzer(email);
    }

    @PostMapping("/countries")
    public VisitedCountry addCountry(@RequestBody Map<String, String> body) {
        return service.add(body.get("country"), body.get("countryCode"), body.get("email"));
    }

    @DeleteMapping("/countries/{countryCode}")
    public void deleteCountry(@PathVariable String countryCode, @RequestParam String email) {
        service.deleteByCodeAndBesitzer(countryCode, email);
    }

    // ── Reisen ───────────────────────────────────

    // Nur Reisen des eingeloggten Users
    @GetMapping("/reisen")
    public List<Reise> getAllReisen(@RequestParam String email) {
        return reiseService.getByBesitzer(email);
    }

    @PostMapping("/reisen")
    public Reise addReise(@RequestBody Reise reise) {
        return reiseService.save(reise);
    }

    @PutMapping("/reisen/{id}")
    public Reise updateReise(@PathVariable Long id, @RequestBody Reise reise) {
        reise.setId(id);
        return reiseService.save(reise);
    }

    @DeleteMapping("/reisen/{id}")
    public void deleteReise(@PathVariable Long id) {
        reiseService.delete(id);
    }

    // ── DiaryEntries ─────────────────────────────

    @GetMapping("/reisen/{id}/entries")
    public List<DiaryEntry> getEntries(@PathVariable Long id) {
        return diaryEntryService.getByReise(id);
    }

    @PostMapping("/entries")
    public DiaryEntry addEntry(@RequestBody DiaryEntry entry) {
        return diaryEntryService.save(entry);
    }

    @PutMapping("/entries/{id}")
    public DiaryEntry updateEntry(@PathVariable Long id, @RequestBody DiaryEntry entry) {
        entry.setId(id);
        return diaryEntryService.save(entry);
    }

    @DeleteMapping("/entries/{id}")
    public void deleteEntry(@PathVariable Long id) {
        diaryEntryService.delete(id);
    }

    // ── Geplante Orte ─────────────────────────────

    @GetMapping("/reisen/{id}/orte")
    public List<GeplanterOrt> getOrte(@PathVariable Long id) {
        return geplanterOrtService.getByReise(id);
    }

    @PostMapping("/orte")
    public GeplanterOrt addOrt(@RequestBody GeplanterOrt ort) {
        return geplanterOrtService.save(ort);
    }

    @DeleteMapping("/orte/{id}")
    public void deleteOrt(@PathVariable Long id) {
        geplanterOrtService.delete(id);
    }

    // ── Fotos ─────────────────────────────────────

    @GetMapping("/entries/{id}/fotos")
    public List<EntryFoto> getFotos(@PathVariable Long id) {
        return fotoService.getByEntry(id);
    }

    @PostMapping("/entries/{id}/fotos")
    public EntryFoto addFoto(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return fotoService.save(id, body.get("imageData"), body.get("dateiname"));
    }

    @DeleteMapping("/fotos/{id}")
    public void deleteFoto(@PathVariable Long id) {
        fotoService.delete(id);
    }
}