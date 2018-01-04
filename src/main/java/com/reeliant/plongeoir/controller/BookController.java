package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.LoginDTO;
import com.reeliant.plongeoir.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController{

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ModelAndView displayBookPage() {
        BookAndCategoryDTO info = bookService.getBooksAndCategories();
        return new ModelAndView("books","infos",info);
    }

    @GetMapping("/create/book")
    public ModelAndView displayCreateBookPage() {

        return new ModelAndView("login","login",new BookCreateDTO());
    }

    @PostMapping("/create/book")
    public ModelAndView submitCreateBookPage(@ModelAttribute BookCreateDTO bookCreation) {
        bookService.createBook(bookCreation);
        return new ModelAndView("bo-home","success","Création du livre réussie");
    }
}
