package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.form.BookCreateDTO;
import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.BorrowService;
import com.reeliant.plongeoir.service.CategoryService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
public class BookController{

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/book")
    public String displayBookPage(Model model) {
        BookAndCategoryDTO info = bookService.getBooksAndCategories();
        model.addAttribute("infos",info);
        return "books";
    }

    @GetMapping("/bo/book/create")
    public String displayCreateBookPage(Model model) {
        model.addAttribute("book",new BookCreateDTO());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "bo-create-book";
    }

    @PostMapping("/bo/book/create")
    public String submitCreateBookPage(@ModelAttribute BookCreateDTO book, Model model) {
        try {
            bookService.createBook(book);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Impossible de créer le livre");
            return "bo/bo-home";
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error","Impossible de créer le livre");
            return "bo/bo-home";
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("error","Impossible de créer le livre");
            return "bo/bo-home";
        }
        return "redirect:/bo/home";
    }

    @GetMapping("/bo/book/{id}")
    public String displayDetailBookPage(@PathVariable("id") Long id, Model model) {
        BookDTO book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "bo/bo-detail-book";
    }

    @DeleteMapping("/bo/book/delete/{id}")
    @ResponseBody
    public ResponseEntity deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/bo/book/borrow/{id}")
    @ResponseBody
    public ResponseEntity borrowBook(@PathVariable("id") Long id) {
        borrowService.borrowBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/bo/book/borrow/{id}")
    @ResponseBody
    public ResponseEntity deleteBorrow(@PathVariable("id") Long id) {
        borrowService.deleteBorrow(id);
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
        return "bo/bo-update-book";
    }

    @PostMapping("/bo/book/update/{id}")
    public String displayUpdateBookPage(@PathVariable("id") Long id, @ModelAttribute BookCreateDTO book, Model model) {
        try {
            bookService.updateBook(book,id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/bo/home";
    }

    @GetMapping("/book/{id}")
    public String displayDetailBookPage(@PathVariable long id, Model model) {
        model.addAttribute("book",bookService.getBookById(id));
        return "fo/book-detail";
    }

}
