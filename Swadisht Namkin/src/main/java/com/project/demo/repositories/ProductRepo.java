package com.project.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Product;

public interface ProductRepo extends JpaRepository< Product , Long> {


	Optional<Product> findById(Long productId);

}
