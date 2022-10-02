package com.piseth.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.phoneshop.dto.BrandDTO;
import com.piseth.java.school.phoneshop.mapper.EntityMapper;
import com.piseth.java.school.phoneshop.model.Brand;
import com.piseth.java.school.phoneshop.service.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<Brand> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = EntityMapper.toBrand(brandDTO);
		brand = brandService.save(brand);
		return ResponseEntity.ok(brand);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Brand> getById(@PathVariable("id") int id){
		return ResponseEntity.ok(brandService.getById(id));
	}
	
}
