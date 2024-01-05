package com.backend2.productreview.repository;
import com.backend2.productreview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
