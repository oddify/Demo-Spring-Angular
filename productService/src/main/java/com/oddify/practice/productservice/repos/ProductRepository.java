package com.oddify.practice.productservice.repos;

import com.oddify.practice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("Select p from Product p order by p.createdAt desc")
    List<Product> findAllOrderByCreatedAtDesc();

    @Query(value = "select * from product_service.product p order by p.created_At",nativeQuery = true)
    List<Product> findAllOrderByCreateAtAsc();
}
