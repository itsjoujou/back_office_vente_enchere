package app.service;

import app.model.Commission;
import app.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommissionService {
    @Autowired
    private final CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    public void save(Commission newCommission) {
        newCommission.setDateDebut(Timestamp.valueOf(LocalDateTime.now()));
        commissionRepository.save(newCommission);
    }

    public List<Commission> getCommissions() {
        return commissionRepository.findAll();
    }
}
