package org.example.oddify.demo.productserviceapr24.services;

import org.example.oddify.demo.productserviceapr24.models.Product;
import org.example.oddify.demo.productserviceapr24.projections.ProductWithTitleAndDesc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductByID(long id);
    List<Product> getProducts();

    Product createNewProduct(Product product);

    Product replaceProduct(long id, Product product);

    Product updateProduct(long id, Product product);

    Product deleteProduct(long id);

//    default ProductWithTitleAndDesc getProductTitleAndDesc(long id){
//        return null;
//    }
}
