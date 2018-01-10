package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
        @Autowired
        private CategoryService categoryService;

        @GetMapping("/bo/category/create")
        public String displayCategoryCreationPage(Model model) {
                model.addAttribute("category",new CategoryDTO());
                return "bo/bo-create-category";
        }

        @PostMapping("/bo/category/create")
        public String submitCategoryCreation(@ModelAttribute CategoryDTO category) {
                categoryService.createCategory(category);
                return "redirect:/bo/home";
        }

        @GetMapping("/bo/category/{id}")
        public String displayDetailCategoryPage(@PathVariable("id") Long id, Model model) {
                CategoryDTO category = categoryService.getById(id);
                model.addAttribute("category",category);
                return "bo/bo-detail-category";
        }

        @DeleteMapping("/bo/category/delete/{id}")
        @ResponseBody
        public ResponseEntity deleteCategory(@PathVariable("id") Long id) {
                categoryService.delete(id);
                return ResponseEntity.ok(HttpStatus.OK);
        }

        @GetMapping("/bo/category/update/{id}")
        public String displayUpdateCategoryPage(@PathVariable("id") Long id, Model model) {
                CategoryDTO categoryToUpdate = categoryService.getById(id);
                model.addAttribute("category",categoryToUpdate);
                model.addAttribute("id",id);
                return "bo/bo-update-category";
        }

        @PostMapping("/bo/category/update/{id}")
        public String submitCategoryUpdate(@PathVariable("id") Long id, @ModelAttribute CategoryDTO category) {
                categoryService.updateCategory(category,id);
                return "redirect:/bo/home";
        }
}
