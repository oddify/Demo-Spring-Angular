package org.example.oddify.demo.productserviceapr24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String image;
    private String Category;
    private String description;
}
