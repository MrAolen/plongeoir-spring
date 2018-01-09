package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BackOfficeDataDTO;
import com.reeliant.plongeoir.dto.LoginDTO;
import com.reeliant.plongeoir.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public ModelAndView displayLoginpage() {
        return new ModelAndView("login","login",new LoginDTO());
    }

    @GetMapping("/bo/login")
    public String displayBoLoginPage(Model model) {
        model.addAttribute("login",new LoginDTO());
        return "bo-login";
    }
}
