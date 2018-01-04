package com.reeliant.plongeoir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
        @GetMapping("/home")
        public String displayHomePage() {
                return "home";
        }
}
