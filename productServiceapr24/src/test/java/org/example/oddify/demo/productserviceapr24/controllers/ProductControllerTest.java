package org.example.oddify.demo.productserviceapr24.controllers;

import org.example.oddify.demo.productserviceapr24.exceptions.ProductLimitReachedException;
import org.example.oddify.demo.productserviceapr24.models.Product;
import org.example.oddify.demo.productserviceapr24.repos.ProductRepo;
import org.example.oddify.demo.productserviceapr24.services.FakeStoreProductService;
import org.example.oddify.demo.productserviceapr24.services.ProductService;
import org.example.oddify.demo.productserviceapr24.services.SelfProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
//@Import(SelfProductService.class) // Ensure the real service is available for spying
class ProductControllerTest {


    @MockBean
    SelfProductService productService ;//= new FakeStoreProductService();

    @Autowired
     ProductController productController;

    @BeforeEach
    void setup(){
        // Trying to mock real method
        // MockitoAnnotations.openMocks(this); // Initialize mocks and injects them

        // Arrange
        Product product = new Product();
        product.setId(2L);
        product.setTitle("Ipad");

        // Rule
        when(productService.getProductByID(any(Long.class))).thenReturn(product);
    }

    @Test
    void Test_WhenGetProductByIdIsCalled_thenGetProduct()
            throws ProductLimitReachedException {


        // Act
        ResponseEntity<Product> p =
                productController.getProductByID(2L);

        // Assert
        assertNotNull(p);
        assertEquals(HttpStatus.OK,p.getStatusCode());
        assertNotNull(p.getBody());
        assertEquals("Ipad",p.getBody().getTitle());
        assertEquals(2L,p.getBody().getId());



    }

    @Test
    void Test_WhenGetProductByIdIsCalled_thenThrowException(){
        // Arrange
        //Rule
        when(productService.getProductByID(any(Long.class))).thenThrow(new RuntimeException("Some thing went wrong"));

        //Act / Assert
        assertThrows(Exception.class, () -> productController.getProductByID(20));

    }


//    @Test
//    void Test_WhenProductByIDIsCalled_thenCallTheRealMethod() throws ProductLimitReachedException {
//        when(productService.getProductByID(any(Long.class))).thenCallRealMethod();
//
//        //Act
//        ResponseEntity<Product> p = productController.getProductByID(2L);
//
//        //Assert
//        assertNotNull(p);
//        assertEquals(HttpStatus.OK,p.getStatusCode());
//
//    }
}