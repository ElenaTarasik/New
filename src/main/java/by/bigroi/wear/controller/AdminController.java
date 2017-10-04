package by.bigroi.wear.controller;

import by.bigroi.wear.model.response.ResponseMessage;
import by.bigroi.wear.model.user.User;
import by.bigroi.wear.service.user.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    List<User> userList;
    String oldEmail;
    User userEdit;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/admin/**")
    public String adminPage(Model model) {
        userList = userService.getAllUsers();
        model.addAttribute("user", new User());
        model.addAttribute("userList", userList);
        return "/admin/admin";
    }

    @PostMapping("/admin/deleteUser")
    public @ResponseBody
    ResponseMessage deleteUser(@RequestBody User user){
        System.out.println("!!!!!!!!!! в контроллере мэйл " + user.getEmail());
        ResponseMessage msg = new ResponseMessage();
        msg.setMessage(userService.deleteUser(user.getEmail()));
        return msg;
    }

    @GetMapping("/admin/editUserPage")
    public String editPage(Model model, HttpServletRequest request) {
        oldEmail = request.getParameter("email");
        userEdit = userService.findByUserEmail(oldEmail);
        model.addAttribute("userEdit", userEdit);
        return "/admin/editPage";
    }

    @GetMapping("/admin/editUser")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        model.addAttribute("userEdit", userEdit);
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "User's data didn't edit");
        } else {
            try {
                model.addAttribute("message", userService.updateUserByEmail(user, oldEmail));
            } catch (Exception e) {
                model.addAttribute("message", "User with this data already exists");
                return "/admin/editPage";
            }
        }
        return "/admin/editPage";
    }

    @GetMapping("/admin/rolePage")
    public String rolePage(Model model, HttpServletRequest request) {
        User user = userService.findByUserEmail(request.getParameter("email"));        ;
        model.addAttribute("userForRole", user);
        model.addAttribute("userRoles", userService.getRoles(user.getId()));
        return "/admin/rolePage";
    }

    @GetMapping("/admin/passwordChange")
    public String passwordChange(Model model) {
        model.addAttribute("user", new User());
        return "/admin/passwordChange";
    }

    @GetMapping("/admin/editPassword")
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
        return "/admin/passwordChange";
    }
}


