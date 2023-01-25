package app.repository;

import app.model.DemandeRecharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DemandeRechargeRepository extends JpaRepository<DemandeRecharge, Integer> {
    List<DemandeRecharge> findDemandeRechargeByDateValidationIsNull();

    @Transactional
    @Modifying
    @Query(value = "UPDATE demande_recharge SET date_validation = CURRENT_TIMESTAMP WHERE id_demande = ?1", nativeQuery = true)
    void validateDemandeRecharche(int id_demande);
}