package app.web;

import app.model.Commission;
import app.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/admin/commissions")
@Controller
public class CommissionController {
    @Autowired
    private final CommissionService service;

    public CommissionController(CommissionService service) {
        this.service = service;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("commissions", service.getCommissions());

        return "commission-list";
    }

    @PostMapping
    public RedirectView create(Commission newCommission) {
        service.save(newCommission);

        return new RedirectView("/admin/commissions");
    }
}
