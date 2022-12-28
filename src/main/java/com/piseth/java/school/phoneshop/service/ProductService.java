package com.piseth.java.school.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.piseth.java.school.phoneshop.dto.ProductDisplayDTO;
import com.piseth.java.school.phoneshop.dto.ProductImportDTO;
import com.piseth.java.school.phoneshop.model.Product;

public interface ProductService {
	Product save(ProductImportDTO productImportDTO);
	Product getById(Long id);
	Product setPrice(Long productId, Double price);
	Page<Product> getProducts(Map<String, String> params);
	List<ProductDisplayDTO> toProductDisplayDTOs(List<Product> products);
}
