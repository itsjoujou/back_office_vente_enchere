package app.service;

import app.model.DemandeRecharge;
import app.model.User;
import app.repository.DemandeRechargeRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemandeRechargeService {
    @Autowired
    private final DemandeRechargeRepository demandeRechargeRepository;
    @Autowired
    private final UserRepository userRepository;

    public DemandeRechargeService(DemandeRechargeRepository demandeRechargeRepository, UserRepository userRepository) {
        this.demandeRechargeRepository = demandeRechargeRepository;
        this.userRepository = userRepository;
    }

    public List<DemandeRecharge> getDemandesRecharge() {
        return demandeRechargeRepository.findDemandeRechargeByDateValidationIsNull();
    }

    @Transactional
    public void validateDemandeRecharge(int id_demande) {
        DemandeRecharge demandeRecharge = demandeRechargeRepository.findById(id_demande).get();
        User user = demandeRecharge.getUser();

        demandeRechargeRepository.validateDemandeRecharche(id_demande);
        userRepository.updateSoldeUser(demandeRecharge.getMontant() + user.getSolde(), user.getId());
    }
}
