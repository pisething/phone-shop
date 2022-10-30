package com.piseth.java.school.phoneshop.service;

import java.util.List;

import com.piseth.java.school.phoneshop.dto.BrandDTO;
import com.piseth.java.school.phoneshop.model.Brand;

public interface BrandService {
	Brand save(Brand entity);

	Brand getById(Integer id);

	Brand update(Integer id, BrandDTO dto);

	void delete(Integer id);

	List<Brand> getBrands();

}
