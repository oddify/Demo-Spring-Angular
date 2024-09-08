package org.example.oddify.demo.productserviceapr24.repos;

import org.example.oddify.demo.productserviceapr24.models.Product;
import org.example.oddify.demo.productserviceapr24.projections.ProductWithTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

        // Declared Query Methods
        @Override
        Optional<Product> findById(Long Id);

        @Override
        void delete(Product product);

        @Override
        Product save(Product product);


        // HQL Query
        @Query("SELECT p.title as title, p.description as desc  FROM Product p WHERE p.id = :id")
        List< ProductWithTitleAndDesc> someRandomQuery(@Param("id") Long id);

        // what is the difference between nativeQuery and Query?
        // nativeQuery is used to write SQL queries, while Query is used to write HQL queries.
        // SQL Query
        @Query(value = "SELECT p.title as title, p.description as desc FROM product p WHERE p.id = :id", nativeQuery = true)
        ProductWithTitleAndDesc someRandomSQLQuery(@Param("id") Long id);



}
