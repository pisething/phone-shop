package com.piseth.java.school.phoneshop.service;

import com.piseth.java.school.phoneshop.model.Brand;

public interface BrandService {
	Brand save(Brand entity);
	Brand getById(Integer id);
	
}
