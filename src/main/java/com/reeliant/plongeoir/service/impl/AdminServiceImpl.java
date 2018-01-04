package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BackOfficeDataDTO;
import com.reeliant.plongeoir.service.AdminService;
import com.reeliant.plongeoir.service.BookService;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public BackOfficeDataDTO getDatasForHomeBackOffice() {
            BackOfficeDataDTO backOfficeDataDTO = new BackOfficeDataDTO();
            backOfficeDataDTO.setBooks(bookService.getAllBooks());
            backOfficeDataDTO.setCategories(categoryService.getAllCategories());
            return backOfficeDataDTO;
    }
}
