package org.example.springmvc.Controller;

import org.example.springmvc.Services.AccountUserService;
import org.springframework.stereotype.Controller;
import org.example.springmvc.Model.AccountUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Controller
public class RegisterAccountController {

    private final AccountUserService accountUserService;

    @Autowired
    public RegisterAccountController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @GetMapping("/RegisterAccount")
    public String showRegisterAccountForm() {
        return "RegisterAccount";
    }

    @PostMapping("/RegisterAccount")
    @ResponseStatus(HttpStatus.FOUND)
    public String registerAccount(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String email,
                                  @RequestParam String phone) {
        AccountUser newUser = new AccountUser(username, password, email, phone);
        boolean registrationSuccessful = accountUserService.registerUser(newUser);
        if (registrationSuccessful) {
            return "redirect:/Login";
        } else {
            return "redirect:Error";
        }

        //        accountUserService.registerUser(newUser);
        //        return "redirect:/Login";

    }
}



