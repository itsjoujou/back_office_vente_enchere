package app.web;

import app.service.DemandeRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/admin/demandes_recharge")
@Controller
public class DemandeRechargeController {
    @Autowired
    public final DemandeRechargeService demandeRechargeService;

    public DemandeRechargeController(DemandeRechargeService demandeRechargeService) {
        this.demandeRechargeService = demandeRechargeService;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("demandes", demandeRechargeService.getDemandesRecharge());

        return "demande-recharge-list";
    }

    @GetMapping("/{id_demande}")
    public RedirectView validate(@PathVariable int id_demande) {
        demandeRechargeService.validateDemandeRecharge(id_demande);

        return new RedirectView("/admin/demandes_recharge");
    }
}
