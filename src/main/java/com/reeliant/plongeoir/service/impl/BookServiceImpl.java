package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.mapper.BookMapper;
import com.reeliant.plongeoir.repository.BookRepository;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public BookAndCategoryDTO getBooksAndCategories() {
        BookAndCategoryDTO info = new BookAndCategoryDTO();
        info.setBooks(getAllBooks());
        info.setCategories(categoryService.getAllCategories());
        return info;
    }

    @Override
    public List<BookDTO> getAllBooks() {
       // return bookRepository.findAll().stream().map(bookMapper::bookToBookDTO).collect(Collectors.toList());
        BookDTO book = new BookDTO();
        book.setTitle("Le nom du vent");

        BookDTO book2 = new BookDTO();
        book2.setTitle("Harry Potter");

        List<BookDTO> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        return books;
    }
}
