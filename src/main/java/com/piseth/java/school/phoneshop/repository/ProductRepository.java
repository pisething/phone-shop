package com.piseth.java.school.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.school.phoneshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
