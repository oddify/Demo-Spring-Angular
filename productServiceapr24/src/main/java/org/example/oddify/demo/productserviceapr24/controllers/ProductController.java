package org.example.oddify.demo.productserviceapr24.controllers;

import org.example.oddify.demo.productserviceapr24.exceptions.ProductLimitReachedException;
import org.example.oddify.demo.productserviceapr24.models.Product;
import org.example.oddify.demo.productserviceapr24.projections.ProductWithTitleAndDesc;
import org.example.oddify.demo.productserviceapr24.services.ProductService;
import org.example.oddify.demo.productserviceapr24.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductService productService;
    private TokenService tokenService;

    @Autowired
    ProductController(ProductService productService, TokenService tokenService){
        this.productService = productService;
        this.tokenService = tokenService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID( @PathVariable long id) throws ProductLimitReachedException {
//        switch ((int) id){
//            case 1:
//                throw new IndexOutOfBoundsException();
//            case 2:
//                throw new RuntimeException();
//            case 3:
//                throw new NullPointerException();
//            case 4:
//                throw new ProductLimitReachedException("Product limit reached");
//            default:
//                return new ResponseEntity<Product>(productService.getProductByID(id), HttpStatus.OK) ;
//        }
//            if(!tokenService.validateToken(token)){
//                return new ResponseEntity<Product>(HttpStatus.FORBIDDEN);
//            }

            return new ResponseEntity<Product>(productService.getProductByID(id), HttpStatus.OK) ;
    }

//    @GetMapping("/titleDesc/{id}")
//    public ResponseEntity<ProductWithTitleAndDesc> getProductTitleAndDesc(@PathVariable long id){
//        return new ResponseEntity<ProductWithTitleAndDesc>(productService.getProductTitleAndDesc(id), HttpStatus.OK);
//    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product createNewProduct(@RequestBody Product product)
    {
        return  productService.createNewProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable long id, @RequestBody Product product){
        return  new Product();

    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }


    @DeleteMapping("/{id}")
    public Product deleteProduct (@PathVariable long id){
        return new Product();
    }

//    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> runtimeExceptionHandler(){
        return new ResponseEntity<String>("Runtime exception occurred",HttpStatus.NOT_FOUND);
    }

}
