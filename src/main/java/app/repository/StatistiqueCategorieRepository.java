package app.repository;

import app.model.StatistiqueCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatistiqueCategorieRepository extends JpaRepository<StatistiqueCategorie, Short> {
}