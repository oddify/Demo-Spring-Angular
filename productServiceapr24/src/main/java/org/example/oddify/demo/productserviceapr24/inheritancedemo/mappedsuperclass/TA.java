package org.example.oddify.demo.productserviceapr24.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_ta")
public class TA extends  User{
    private int noOfSessions;
    private  double avgRating;
}
