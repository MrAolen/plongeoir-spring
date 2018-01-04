package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.BookAndCategoryDTO;
import com.reeliant.plongeoir.dto.BookDTO;

import java.util.List;

public interface BookService{
    BookAndCategoryDTO getBooksAndCategories();

    List<BookDTO> getAllBooks();
}
