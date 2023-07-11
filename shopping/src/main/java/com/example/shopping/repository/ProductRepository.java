package com.example.shopping.repository;

import com.example.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT AVG(c.rate) FROM Comment c WHERE c.product_id = ?1", nativeQuery = true)
    double countAvgRate(String productId);
}
