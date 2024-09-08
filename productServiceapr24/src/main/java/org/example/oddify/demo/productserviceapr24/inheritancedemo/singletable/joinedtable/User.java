package org.example.oddify.demo.productserviceapr24.inheritancedemo.singletable.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "st_users")
@DiscriminatorColumn(name = "user_typ",discriminatorType= DiscriminatorType.INTEGER)
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;
}
