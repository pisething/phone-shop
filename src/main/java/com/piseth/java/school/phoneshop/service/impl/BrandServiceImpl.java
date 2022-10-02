package com.piseth.java.school.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.piseth.java.school.phoneshop.model.Brand;
import com.piseth.java.school.phoneshop.repository.BrandRepository;
import com.piseth.java.school.phoneshop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository brandRepositoty;

	@Override
	public Brand save(Brand entity) {
		return brandRepositoty.save(entity);
	}

	@Override
	public Brand getById(Integer id) {
		 Optional<Brand> brandOptional = brandRepositoty.findById(id);
		 
		 if(brandOptional.isPresent()) {
			 return brandOptional.get();
		 }else {
			 throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("brand not found for id=%d", id));
		 }
		 
	}

}
