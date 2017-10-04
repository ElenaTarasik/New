package by.bigroi.wear.controller;

import by.bigroi.wear.model.user.User;
import by.bigroi.wear.service.user.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class SecureController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPageAfterLogout(Model model) {
        model.addAttribute("user", new User());
        return "/user/login";
    }

    @GetMapping("/user/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "/user/login";
    }

    @GetMapping("/user/secure/**")
    public String userPage(Model model) {
        model.addAttribute("user", new User());
        return "/user/secure";
    }

    @PostMapping("/j_spring_security_check")
    public String loginPage(@ModelAttribute("user") @Valid User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Login user error");
            return "/user/login";
        } else {
            model.addAttribute("message", "You are on user page");
        }
        return "/user/secure";
    }

    @GetMapping("/user/secure/editUserPassword")
    public String ediPassword(Model model, HttpServletRequest request) {
        User user = userService.findByUserEmail(request.getParameter("login"));
        String passResult = userService.checkPass(user, request.getParameter("oldPass"),
                request.getParameter("new1Pass"), request.getParameter("new2Pass"));
        if(!passResult.equals("Ok")){
            model.addAttribute("message", passResult);
        } else {
            userService.updateUserPassword(user, request.getParameter("new2Pass"));
            model.addAttribute("message", "User's password updated successfully");
        }
        return "/user/login";
    }
}
