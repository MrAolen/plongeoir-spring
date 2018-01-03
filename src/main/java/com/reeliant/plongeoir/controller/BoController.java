package com.reeliant.plongeoir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoController {

        @GetMapping("/bo/login")
        public String displayLoginPage() {
                return "admin-login";
        }

        @GetMapping("/bo/home")
        public String displayHomePage() {
                return "admin-home";
        }


}