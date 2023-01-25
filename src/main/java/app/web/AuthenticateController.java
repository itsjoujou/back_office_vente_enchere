package app.web;

import app.model.User;
import app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/authenticate")
@Controller
public class AuthenticateController {
    @Autowired
    private final UserService service;

    public  AuthenticateController(UserService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String toSignInPageAsAdmin() {
        return "admin-login-form";
    }

    @PostMapping("/admin")
    public RedirectView AuthenticateAsAdmin(User authenticateUser, HttpSession session, Model model) {
        User newUser = service.authenticate(authenticateUser, 1);
        if (newUser == null) {
            model.addAttribute("message", "No user found!");
            return new RedirectView("/authenticate/admin");
        }

        session.setAttribute("admin", newUser);

        return new RedirectView("/admin/dashboard");
    }
}
