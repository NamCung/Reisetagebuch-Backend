package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;

@Entity
public class GeplanterOrt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String ort;
    Double latitude;
    Double longitude;
    String notiz;
    String kategorie;
    Double rating;
    String placeId;

    @ManyToOne
    @JoinColumn(name = "reise_id")
    Reise reise;

    public GeplanterOrt() {}

    public GeplanterOrt(String name, String ort, Double latitude, Double longitude,
                        String notiz, String kategorie, Reise reise) {
        this.name = name;
        this.ort = ort;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notiz = notiz;
        this.kategorie = kategorie;
        this.reise = reise;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOrt() { return ort; }
    public void setOrt(String ort) { this.ort = ort; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getNotiz() { return notiz; }
    public void setNotiz(String notiz) { this.notiz = notiz; }

    public String getKategorie() { return kategorie; }
    public void setKategorie(String kategorie) { this.kategorie = kategorie; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getPlaceId() { return placeId; }
    public void setPlaceId(String placeId) { this.placeId = placeId; }

    public Reise getReise() { return reise; }
    public void setReise(Reise reise) { this.reise = reise; }

    @Override
    public String toString() {
        return "GeplanterOrt{id=" + id + ", name='" + name + "', kategorie='" + kategorie + "', reise=" + reise + "}";
    }
}