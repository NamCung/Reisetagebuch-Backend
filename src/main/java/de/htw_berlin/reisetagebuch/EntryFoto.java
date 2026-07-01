package de.htw_berlin.reisetagebuch;

import jakarta.persistence.*;

@Entity
public class EntryFoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Das Foto wird als Base64-String gespeichert
    // z.B. "data:image/jpeg;base64,/9j/4AAQSkZJRgAB..."
    @Column(columnDefinition = "TEXT")
    String imageData;

    String dateiname;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    DiaryEntry entry;

    public EntryFoto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImageData() { return imageData; }
    public void setImageData(String imageData) { this.imageData = imageData; }

    public String getDateiname() { return dateiname; }
    public void setDateiname(String dateiname) { this.dateiname = dateiname; }

    public DiaryEntry getEntry() { return entry; }
    public void setEntry(DiaryEntry entry) { this.entry = entry; }
}