package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.CategoryDTO;

import java.util.List;

public interface CategoryService{
    List<CategoryDTO> getAllCategories();

    CategoryDTO getById(Long id);
}
