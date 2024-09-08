package org.example.oddify.demo.productserviceapr24.services;

import org.example.oddify.demo.productserviceapr24.dtos.FakeStoreProductDto;
import org.example.oddify.demo.productserviceapr24.models.Category;
import org.example.oddify.demo.productserviceapr24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
//@Primary
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductByID(long id) {
        FakeStoreProductDto fs = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return fakeStoreProductConverter(fs);
    }

    @Override
    public List<Product> getProducts() {
       FakeStoreProductDto[] list =

        restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto fs : list){
            productList.add(fakeStoreProductConverter(fs));
        }

        return productList;
    }

    @Override
    public Product createNewProduct(Product product) {
        FakeStoreProductDto  fsdt = productToFakeStoreConverter(product);

        fsdt = restTemplate.postForObject("https://fakestoreapi.com/products", fsdt, FakeStoreProductDto.class);
        return  fakeStoreProductConverter(fsdt);
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        FakeStoreProductDto  ftd = productToFakeStoreConverter(product);

        ftd = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, ftd,FakeStoreProductDto.class);
        return fakeStoreProductConverter(ftd);
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    private Product fakeStoreProductConverter(FakeStoreProductDto fsdto) {
        if (fsdto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(fsdto.getId());
        product.setTitle(fsdto.getTitle());
        product.setPrice(fsdto.getPrice());
        product.setDescription(fsdto.getDescription());

        Category cate = new Category();
        cate.setTitle(fsdto.getCategory());

        product.setCategory(cate);

        return product;
    }

    private FakeStoreProductDto productToFakeStoreConverter(Product product){
        if (product == null) {
            return null;
        }

        FakeStoreProductDto fsdto = new FakeStoreProductDto();

        fsdto.setId(product.getId());
        fsdto.setTitle(product.getTitle());
        fsdto.setPrice(product.getPrice());
        fsdto.setDescription(product.getDescription());

        if(product.getCategory() != null){
            fsdto.setCategory(product.getCategory().getTitle());
        }else{
            fsdto.setCategory(null);
        }

        return fsdto;

    }

}
