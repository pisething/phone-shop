package com.piseth.java.school.phoneshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.piseth.java.school.phoneshop.dto.BrandDTO;
import com.piseth.java.school.phoneshop.model.Brand;
import com.piseth.java.school.phoneshop.repository.BrandRepository;
import com.piseth.java.school.phoneshop.service.BrandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	@Override
	public Brand update(Integer id, BrandDTO dto) {
		Brand brand = getById(id);
		brand.setName(dto.getName());
		return brandRepositoty.save(brand);
	}

	@Override
	public void delete(Integer id) {
		Brand brand = getById(id);
		brandRepositoty.delete(brand);
		log.info("brand with id = %d is deleted".formatted(id));
		//log.info(String.format("brand with id = %d is deleted", id));
	}

	@Override
	public List<Brand> getBrands() {
		return brandRepositoty.findAll();
	}

}
