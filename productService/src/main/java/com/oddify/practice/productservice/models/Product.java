package com.oddify.practice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

// Json
//     {
//         "name": "Product 1",
//         "description": "Mens shirt",
//         "price": 100.0,
//         "quantity": 10,
//         "imageUrl": "https://www.google.com",
//         "category": {
//             "id": 1,
//           "name": "shirts"
//         }
//     }

}
