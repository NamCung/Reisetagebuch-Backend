package de.htw_berlin.reisetagebuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntryFotoService {

    @Autowired
    EntryFotoRepository repo;

    @Autowired
    DiaryEntryRepository entryRepo;

    public List<EntryFoto> getByEntry(Long entryId) {
        return repo.findByEntryId(entryId);
    }

    public EntryFoto save(Long entryId, String imageData, String dateiname) {
        DiaryEntry entry = entryRepo.findById(entryId).orElse(null);
        if (entry == null) return null;

        EntryFoto foto = new EntryFoto();
        foto.setImageData(imageData);
        foto.setDateiname(dateiname);
        foto.setEntry(entry);
        return repo.save(foto);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}