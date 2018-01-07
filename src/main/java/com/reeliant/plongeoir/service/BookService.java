package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.BookDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface BookService{
    BookAndCategoryDTO getBooksAndCategories();

    List<BookDTO> getAllBooks();

    Long createBook(BookCreateDTO bookCreation) throws IOException, SQLException, ParseException;

    BookDTO getBookById(Long id);
}
