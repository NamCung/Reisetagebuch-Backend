package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String titel;
    LocalDate startDatum;
    LocalDate endDatum;
    String reiseziel;
    String beschreibung;
    String status;

    // Email des Besitzers für Datentrennung
    String besitzer;

    public Reise() { this.status = "ENTWURF"; }

    public Reise(String titel, LocalDate startDatum, LocalDate endDatum,
                 String reiseziel, String beschreibung) {
        this.titel = titel;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.reiseziel = reiseziel;
        this.beschreibung = beschreibung;
    }

    public Reise(String titel, LocalDate startDatum, LocalDate endDatum,
                 String reiseziel, String beschreibung, String status) {
        this.titel = titel;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.reiseziel = reiseziel;
        this.beschreibung = beschreibung;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public LocalDate getStartDatum() { return startDatum; }
    public void setStartDatum(LocalDate startDatum) { this.startDatum = startDatum; }

    public LocalDate getEndDatum() { return endDatum; }
    public void setEndDatum(LocalDate endDatum) { this.endDatum = endDatum; }

    public String getReiseziel() { return reiseziel; }
    public void setReiseziel(String reiseziel) { this.reiseziel = reiseziel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBesitzer() { return besitzer; }
    public void setBesitzer(String besitzer) { this.besitzer = besitzer; }

    @Override
    public String toString() {
        return "Reise{id=" + id + ", titel='" + titel + "', reiseziel='" + reiseziel + "', status='" + status + "'}";
    }
}