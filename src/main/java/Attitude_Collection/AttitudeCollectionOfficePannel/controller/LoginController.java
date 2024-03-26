package Attitude_Collection.AttitudeCollectionOfficePannel.controller;
import org.springframework.web.context.request.ServletRequestAttributes;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.Sessionresponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attitudeCollection")
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public String login(@ModelAttribute Login login, HttpSession session) {
        Sessionresponse logindtl = loginService.logindetails(login);
        System.out.println(logindtl.getUserId());
        if(logindtl.getUserId() != null)
        {
            session.setAttribute("username",logindtl.getName());
            session.setAttribute("role",logindtl.getUserRole());
            session.setAttribute("userId",logindtl.getUserId());
            return "redirect:/";
        }

        return "redirect:/attitudeCollection/";
    }

    @GetMapping("/")
    public String loadlogin()
    {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {

            session.invalidate();
        return "login";
    }
}
