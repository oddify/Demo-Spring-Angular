package com.oddify.practice.productservice.services;

import com.oddify.practice.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createNewProduct(Product product);

    Product replaceProduct(Long id , Product product);

    Product updateProduct(Long id , Product product);

    Product deleteProduct(Long id);

}
