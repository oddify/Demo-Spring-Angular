package org.example.oddify.demo.productserviceapr24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Product")
public class Product extends  BaseModel {


    private  String title;

    private double price;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @JoinColumn
    private Category category;


    private String description;

    private int quantity;

    private boolean isDeleted;
}

