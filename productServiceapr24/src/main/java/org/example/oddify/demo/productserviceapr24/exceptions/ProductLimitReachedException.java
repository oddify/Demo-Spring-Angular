package org.example.oddify.demo.productserviceapr24.exceptions;

public class ProductLimitReachedException  extends Exception{
    public ProductLimitReachedException(String message) {
        super(message);
    }
}
