package org.example.springmvc.Controller;

import org.example.springmvc.Model.AccountUser;
import org.example.springmvc.Model.User;
import org.example.springmvc.Services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserLoginService userService;

    @GetMapping("/Login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping("/Login")
    public String Login(AccountUser user) {
//        ,HttpSession session
        if (userService.authenticate(user)) {
//            session.setAttribute("loggedInUserName", user.getUsername());
            return "redirect:/Home";
        } else {
            return "redirect:/Error";
        }
    }
}