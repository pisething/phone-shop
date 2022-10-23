package com.piseth.java.school.phoneshop.service;

import java.util.List;

import com.piseth.java.school.phoneshop.dto.BrandDTO;
import com.piseth.java.school.phoneshop.exception.ApiException;
import com.piseth.java.school.phoneshop.model.Brand;

public interface BrandService {
	Brand save(Brand entity);

	Brand getById(Integer id) throws ApiException;

	Brand update(Integer id, BrandDTO dto) throws ApiException;
	
	void delete(Integer id) throws ApiException;
	
	List<Brand> getBrands();

}
