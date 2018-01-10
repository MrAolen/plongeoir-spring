package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.form.LoginDTO;
import com.reeliant.plongeoir.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController{
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String displayLoginpage(Model model) {
        model.addAttribute("login",new LoginDTO());
        return "fo/login";
    }

    @GetMapping("/bo/login")
    public String displayBoLoginPage(Model model) {
        model.addAttribute("login",new LoginDTO());
        return "bo/bo-login";
    }
}
