package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String text;
    LocalDate datum;
    String ort;
    Double latitude;
    Double longitude;

    @ManyToOne
    @JoinColumn(name = "reise_id")
    Reise reise;

    public DiaryEntry() {}

    public DiaryEntry(String text, LocalDate datum, String ort,
                           Double latitude, Double longitude, Reise reise) {
        this.text = text;
        this.datum = datum;
        this.ort = ort;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reise = reise;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public String getOrt() { return ort; }
    public void setOrt(String ort) { this.ort = ort; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Reise getReise() { return reise; }
    public void setReise(Reise reise) { this.reise = reise; }

    @Override
    public String toString() {
        return "Tagebucheintrag{id=" + id + ", datum=" + datum +
                ", ort='" + ort + "', reise=" + reise + "}";
    }}