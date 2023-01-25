package app.service;

import app.model.Categorie;
import app.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    public void save(Categorie newCategorie) {
        categorieRepository.save(newCategorie);
    }

    public void update(Categorie newCategorie, short id) {
        categorieRepository.findById(id).map(categorie -> {
            categorie.setLibelleCategorie(newCategorie.getLibelleCategorie());

            return categorieRepository.save(categorie);
        });
    }

    public void delete(short id) {
        categorieRepository.deleteById(id);
    }
}
