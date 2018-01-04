package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
    @GetMapping("/login")
    public ModelAndView displayLoginpage() {
        return new ModelAndView("login","login",new LoginDTO());
    }

    @PostMapping("/login")
    public ModelAndView submitLoginPage() {
        return new ModelAndView("home");
    }
}
