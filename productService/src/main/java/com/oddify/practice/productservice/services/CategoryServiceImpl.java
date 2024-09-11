package com.oddify.practice.productservice.services;

import com.oddify.practice.productservice.models.Category;
import com.oddify.practice.productservice.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Category CreateIfNotExist(Category category) {
        Optional<Category>  existingCategory =categoryRepo.findByName(category.getName());

        if(existingCategory.isEmpty()){
            Category createdCategory = new Category();
            // set attributes
            createdCategory.setName(category.getName());

            return categoryRepo.save(createdCategory);
        }else {
            return existingCategory.get();
        }

    }
}
