package org.example.oddify.demo.productserviceapr24.services;

import org.example.oddify.demo.productserviceapr24.models.Category;
import org.example.oddify.demo.productserviceapr24.models.Product;
import org.example.oddify.demo.productserviceapr24.projections.ProductWithTitleAndDesc;
import org.example.oddify.demo.productserviceapr24.repos.CategoryRepo;
import org.example.oddify.demo.productserviceapr24.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService{

    CategoryRepo categoryRepo;
    ProductRepo  productRepo;

    @Autowired
    SelfProductService(ProductRepo productRepo,CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductByID(long id) {

        Optional<Product> product = productRepo.findById(id);

        return product.orElse(null);

    }


//    public ProductWithTitleAndDesc getProductTitleAndDesc(long id){
//        return productRepo.someRandomQuery(id).get(1);
//    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createNewProduct(Product product) {
        Category  category = product.getCategory();

        if(category.getId() == null){
            category = categoryRepo.save(category);
            product.setCategory(category);
        }

        Product p = productRepo.save(product);
        return  p;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }


}
