package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.entity.Book;
import com.reeliant.plongeoir.mapper.BookMapper;
import com.reeliant.plongeoir.repository.BookRepository;
import com.reeliant.plongeoir.repository.CategoryRepository;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BookAndCategoryDTO getBooksAndCategories() {
        BookAndCategoryDTO info = new BookAndCategoryDTO();
        info.setBooks(getAllBooks());
        info.setCategories(categoryService.getAllCategories());
        return info;
    }

    @Override
    public List<BookDTO> getAllBooks() {
       return bookRepository.findAll().stream().map(bookMapper::bookToBookDTO).collect(Collectors.toList());
    }

    @Override
    public Long createBook(BookCreateDTO bookCreation) throws IOException, SQLException {
        Book book = new Book();
        book.setCategory(categoryRepository.findOne(bookCreation.getCategoryId()));
        book.setImage(bookCreation.getImage().getBytes());
        book.setParutionDate(bookCreation.getParutionDate());
        book.setSummary(bookCreation.getSummary());
        book.setTitle(bookCreation.getTitle());

        return bookRepository.save(book).getId();
    }
}
