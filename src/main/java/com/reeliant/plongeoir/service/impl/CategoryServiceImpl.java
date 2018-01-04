package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.mapper.CategoryMapper;
import com.reeliant.plongeoir.repository.CategoryRepository;
import com.reeliant.plongeoir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        //return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDTO).collect(Collectors.toList());
        CategoryDTO category = new CategoryDTO();
        category.setLabel("fantastique");

        CategoryDTO category2 = new CategoryDTO();
        category2.setLabel("fiction");

        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(category);
        categories.add(category2);
        return categories;
    }
}
