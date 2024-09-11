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

    CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;

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

        Category category = categoryService.CreateIfNotExist(product.getCategory());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        Optional<Product> existingProduct  = productRepository.findById(id);
        if(existingProduct.isPresent()){
           return this.createNewProduct(product);
        }
        else {
            throw new RuntimeException("Product Not found");
        }
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct  = productRepository.findById(id);
        if(existingProduct.isEmpty()){
            throw new RuntimeException("Product not found");
        }

        Product updatedProduct = existingProduct.get();

        if(product.getCategory() != null){
            Category category = categoryService.CreateIfNotExist(product.getCategory());
            updatedProduct.setCategory(category);
        }

        if(product.getDescription() != null){
            updatedProduct.setDescription(product.getDescription());
        }

        if(product.getImageUrl() != null){
            updatedProduct.setImageUrl(product.getImageUrl());
        }

        if(product.getName() != null){
            updatedProduct.setName(product.getName());
        }

        if (product.getPrice() != null) {
            updatedProduct.setPrice(product.getPrice());
        }

        if(product.getQuantity() != null){
            updatedProduct.setQuantity(product.getQuantity());
        }

        return productRepository.save(updatedProduct);
    }

    @Override
    public Product deleteProduct(Long id) {
        productRepository.deleteById(id);
        return new Product();
    }
}
