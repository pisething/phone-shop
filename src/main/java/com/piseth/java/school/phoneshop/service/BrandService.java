package com.piseth.java.school.phoneshop.service;

import java.util.List;

import com.piseth.java.school.phoneshop.model.Brand;

public interface BrandService {
	Brand save(Brand entity);

	Brand getById(Integer id);

	Brand update(Integer id, Brand brand);

	void delete(Integer id);

	List<Brand> getBrands();

}
