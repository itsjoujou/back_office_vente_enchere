package app.web;

import app.model.DureeEnchere;
import app.service.DureeEnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/admin/duree_enchere")
@Controller
public class DureeEnchereController {
    @Autowired
    private final DureeEnchereService dureeEnchereService;

    public DureeEnchereController(DureeEnchereService dureeEnchereService) {
        this.dureeEnchereService = dureeEnchereService;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("duree_enchere", dureeEnchereService.getDureeEncheres());

        return "duree-enchere-list";
    }

    @PostMapping
    public RedirectView create(DureeEnchere newDureeEnchere) {
        dureeEnchereService.save(newDureeEnchere);

        return new RedirectView("/admin/duree_enchere");
    }
}
