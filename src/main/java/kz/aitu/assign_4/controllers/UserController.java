package kz.aitu.assign_4.controllers;

import kz.aitu.assign_4.models.UserModel;
import kz.aitu.assign_4.services.UserServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiece userServiece;

    public UserController(UserServiece userServiece) {
        this.userServiece = userServiece;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UserModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new UserModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel usersModel){
        System.out.println("regiseter request: "+ usersModel);
        UserModel registerUser = userServiece.registerUser(usersModel.getLogin(),usersModel.getPassword(),usersModel.getEmail());
        return registerUser == null ? "error_rage":"redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel usersModel,Model model){
        System.out.println("login request: "+ usersModel);
        UserModel authenticated = userServiece.authenticate(usersModel.getLogin(),usersModel.getPassword());
        if(authenticated != null){
            model.addAttribute("userLogin",authenticated.getLogin());
            return "rersonal_page";
        }else {
            return "error_page";
        }
    }

}
