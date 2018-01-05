package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BackOfficeDataDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.service.AdminService;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoController {
        @Autowired
        private AdminService adminService;

        @Autowired
        private CategoryService categoryService;

        @GetMapping("/bo/home")
        public ModelAndView displayHomePage() {
                BackOfficeDataDTO backOfficeInformations = adminService.getDatasForHomeBackOffice();
                return new ModelAndView("bo-home","infos",backOfficeInformations);
        }

        @GetMapping("/bo/category/create")
        public ModelAndView displayCategoryCreationPage() {
                return new ModelAndView("bo-create-category","category",new CategoryDTO());
        }

        @PostMapping("/bo/category/create")
        public ModelAndView submitCategoryCreation(@ModelAttribute CategoryDTO category) {
                categoryService.createCategory(category);
                return new ModelAndView("redirect:/bo/home");
        }


}
