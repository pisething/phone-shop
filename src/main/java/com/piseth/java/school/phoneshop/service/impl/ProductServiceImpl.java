package com.piseth.java.school.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop.model.Product;
import com.piseth.java.school.phoneshop.repository.ProductRepository;
import com.piseth.java.school.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

}
