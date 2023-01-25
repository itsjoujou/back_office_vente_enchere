package app.repository;

import app.model.DureeEnchere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DureeEnchereRepository extends JpaRepository<DureeEnchere, Short> {
}