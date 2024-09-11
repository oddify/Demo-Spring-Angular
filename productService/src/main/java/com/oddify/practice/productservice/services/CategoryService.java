package com.oddify.practice.productservice.services;

import com.oddify.practice.productservice.models.Category;

public interface CategoryService {
    Category CreateIfNotExist(Category category);
}
