package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.LoginDTO;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController{

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/book")
    public ModelAndView displayBookPage() {
        BookAndCategoryDTO info = bookService.getBooksAndCategories();
        return new ModelAndView("books","infos",info);
    }

    @GetMapping("/bo/book/create")
    public String displayCreateBookPage(Model model) {
        model.addAttribute("book",new BookCreateDTO());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "bo-create-book";
    }

    @PostMapping("/bo/book/create")
    public ModelAndView submitCreateBookPage(@ModelAttribute BookCreateDTO book) {
        try {
            bookService.createBook(book);
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelAndView("bo-home","error", "Impossible de créer le livre");
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelAndView("bo-home","success","Impossible de créer le livre");
        } catch (ParseException e) {
            e.printStackTrace();
            return new ModelAndView("bo-home","success","Impossible de créer le livre");
        }
        return new ModelAndView("redirect:/bo/home");
    }
}
