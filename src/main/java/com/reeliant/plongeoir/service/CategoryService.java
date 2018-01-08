package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.CategoryDTO;

import java.util.List;

public interface CategoryService{
    List<CategoryDTO> getAllCategories();

    CategoryDTO getById(Long id);

    Long createCategory(CategoryDTO categoryCreation);

    void delete(Long id);

    void updateCategory(CategoryDTO category, Long id);
}
