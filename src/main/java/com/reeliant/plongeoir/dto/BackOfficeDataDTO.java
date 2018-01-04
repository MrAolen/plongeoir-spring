package com.reeliant.plongeoir.dto;

import java.util.List;

public class BackOfficeDataDTO{
    private List<CategoryDTO> categories;
    private List<BookDTO> books;

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
