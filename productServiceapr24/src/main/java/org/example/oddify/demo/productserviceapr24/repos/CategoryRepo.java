package org.example.oddify.demo.productserviceapr24.repos;

import org.example.oddify.demo.productserviceapr24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
