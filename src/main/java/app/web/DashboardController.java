package app.web;

import app.repository.StatistiqueCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/dashboard")
@Controller
public class DashboardController {
    @Autowired
    private final StatistiqueCategorieRepository statistiqueCategorieRepository;

    public DashboardController(StatistiqueCategorieRepository statistiqueCategorieRepository) {
        this.statistiqueCategorieRepository = statistiqueCategorieRepository;
    }

    @GetMapping
    public String toDashboard(Model model) {
        model.addAttribute("stats", statistiqueCategorieRepository.findAll());

        return "dashboard";
    }
}
