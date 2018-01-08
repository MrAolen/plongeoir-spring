package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.entity.Book;
import com.reeliant.plongeoir.entity.Book.StateBook;
import com.reeliant.plongeoir.mapper.BookMapper;
import com.reeliant.plongeoir.mapper.CategoryMapper;
import com.reeliant.plongeoir.repository.BookRepository;
import com.reeliant.plongeoir.repository.CategoryRepository;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private CategoryMapper categoryMapper;

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
    public Long createBook(BookCreateDTO bookCreation) throws IOException, SQLException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Book book = new Book();
        book.setCategory(categoryRepository.findOne(bookCreation.getCategoryId()));
        book.setImage(bookCreation.getImage().getBytes());
        book.setParutionDate(formatter.parse(bookCreation.getParutionDate()));
        book.setSummary(bookCreation.getSummary());
        book.setTitle(bookCreation.getTitle());
        return bookRepository.save(book).getId();
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findOne(id);
        return bookMapper.bookToBookDTO(book);
    }

    @Override
    public Boolean delete(Long id) {
        bookRepository.delete(id);
        return true;
    }

    @Override
    public void updateBook(BookCreateDTO book, Long id) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Book bookToUpdate = bookRepository.findOne(id);
        bookToUpdate.setCategory(categoryRepository.findOne(book.getCategoryId()));
        bookToUpdate.setImage(book.getImage().getBytes());
        bookToUpdate.setParutionDate(formatter.parse(book.getParutionDate()));
        bookToUpdate.setSummary(book.getSummary());
        bookToUpdate.setTitle(book.getTitle());
        bookRepository.save(bookToUpdate).getId();
    }
}
