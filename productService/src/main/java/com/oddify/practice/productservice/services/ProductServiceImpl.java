package com.oddify.practice.productservice.services;

import com.oddify.practice.productservice.models.Category;
import com.oddify.practice.productservice.models.Product;
import com.oddify.practice.productservice.repos.CategoryRepo;
import com.oddify.practice.productservice.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryRepo categoryRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,CategoryRepo categoryRepo){
        this.productRepository = productRepository;
        this.categoryRepo = categoryRepo;

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllOrderByCreateAtAsc();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product =   productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createNewProduct(Product product) {
        Optional<Category> category  = categoryRepo.findByName(product.getCategory().getName());

        if(category.isEmpty()){
           Category newCategory = categoryRepo.save(product.getCategory());
           product.setCategory(newCategory);
        }else {
            product.setCategory(category.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
