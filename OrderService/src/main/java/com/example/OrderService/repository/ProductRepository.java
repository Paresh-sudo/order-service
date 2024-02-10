package com.example.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderService.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
