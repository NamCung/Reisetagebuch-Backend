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

    public Reise() {}

    public Reise(String titel, LocalDate startDatum, LocalDate endDatum,
                 String reiseziel, String beschreibung) {
        this.titel = titel;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.reiseziel = reiseziel;
        this.beschreibung = beschreibung;
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

    @Override
    public String toString() {
        return "Reise{id=" + id + ", titel='" + titel + "', reiseziel='" + reiseziel + "'}";
    }
}