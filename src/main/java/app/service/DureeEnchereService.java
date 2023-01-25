package app.service;

import app.model.DureeEnchere;
import app.repository.DureeEnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DureeEnchereService {
    @Autowired
    private final DureeEnchereRepository dureeEnchereRepository;

    public DureeEnchereService(DureeEnchereRepository dureeEnchereRepository) {
        this.dureeEnchereRepository = dureeEnchereRepository;
    }

    public void save(DureeEnchere newDureeEnchere) {
        newDureeEnchere.setDateDebut(Timestamp.valueOf(LocalDateTime.now()));
        dureeEnchereRepository.save(newDureeEnchere);
    }

    public List<DureeEnchere> getDureeEncheres() {
        return dureeEnchereRepository.findAll();
    }
}
