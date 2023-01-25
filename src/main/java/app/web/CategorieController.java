package app.web;

import app.model.Categorie;
import app.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/admin/categories")
@Controller
public class CategorieController {
    @Autowired
    private final CategorieService service;

    public CategorieController(CategorieService service) {
        this.service = service;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("categories", service.getCategories());

        return "categorie-list";
    }

    @PostMapping
    public RedirectView create(Categorie newCategorie) {
        service.save(newCategorie);

        return new RedirectView("/admin/categories");
    }
}
