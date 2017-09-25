package by.bigroi.wear.controller;

import by.bigroi.wear.model.user.User;
import by.bigroi.wear.service.user.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET})
    public String defaultPage() {
        return "/index";
    }

    @GetMapping("/user/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "/user/registration";
    }

    @GetMapping("/user/saveUser")
    public String saveUserForm(@ModelAttribute ("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "User didn't save to database");
            return "/user/registration";
        } else {
            userService.addUser(user);
            return "/index";
        }
    }
}
