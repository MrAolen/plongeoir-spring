package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.LoginDTO;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.jws.WebParam.Mode;
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

    @GetMapping("/bo/book/{id}")
    public ModelAndView displayDetailBookPage(@PathVariable("id") Long id) {
        BookDTO book = bookService.getBookById(id);
        return new ModelAndView("bo-detail-book","book",book);
    }

    @DeleteMapping("/bo/book/delete/{id}")
    @ResponseBody
    public ResponseEntity deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/bo/book/update/{id}")
    public String displayUpdateBookPage(@PathVariable("id") Long id, Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BookDTO bookToUpdate = bookService.getBookById(id);
        BookCreateDTO bookCreateDTO = new BookCreateDTO();
        bookCreateDTO.setTitle(bookToUpdate.getTitle());
        bookCreateDTO.setSummary(bookToUpdate.getSummary());
        bookCreateDTO.setParutionDate(bookToUpdate.getParutionDate().toInstant().atZone(
                ZoneId.systemDefault()).toLocalDate().format(formatter));
        bookCreateDTO.setCategoryId(bookToUpdate.getCategory().getId());

        model.addAttribute("book",bookCreateDTO);
        model.addAttribute("image",bookToUpdate.getImage());
        model.addAttribute("id",id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "bo-update-book";
    }

    @PostMapping("/bo/book/update/{id}")
    public ModelAndView displayUpdateBookPage(@PathVariable("id") Long id, @ModelAttribute BookCreateDTO book) {
        try {
            bookService.updateBook(book,id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/bo/home");
    }
}
