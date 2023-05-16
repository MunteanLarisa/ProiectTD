package com.ProjectTD.app.ProjectTD.Web;

import com.ProjectTD.app.ProjectTD.Service.UserService;
import com.ProjectTD.app.ProjectTD.Web.DTO.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }
    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDTO){
        userService.save(registrationDTO);
        return "redirect:/registration?success";

    }
}
