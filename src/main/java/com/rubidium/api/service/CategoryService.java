package com.rubidium.api.service;

import java.util.List;

import com.rubidium.api.dto.CategoryDto;
import com.rubidium.api.model.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    List<CategoryDto> getAllCategories();

    Category getCategoryById(long id);

    Category updateCategory(Category category, long id);

    void delete(long id);
}
