package com.reeliant.plongeoir.dto;

import java.util.List;

public class BookAndCategoryDTO{
    private List<BookDTO> books;
    private List<CategoryDTO> categories;

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
