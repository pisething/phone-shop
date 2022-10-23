package com.piseth.java.school.phoneshop.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.exception.ApiException;
import com.piseth.java.school.phoneshop.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop.mapper.ModelMapper;
import com.piseth.java.school.phoneshop.model.Model;
import com.piseth.java.school.phoneshop.repository.ModelRepository;
import com.piseth.java.school.phoneshop.service.BrandService;
import com.piseth.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService{
	
	private final ModelRepository modelRepository;
	
	private final BrandService brandService;

	@Override
	public Model save(ModelDTO dto) throws ApiException {
		
		Integer brandId = dto.getBrandDTO().getId();
		brandService.getById(brandId);
		
		Model model = ModelMapper.INSTANCE.toModel(dto);
		return modelRepository.save(model);
	}

	@Override
	public Model getById(Integer id) throws ApiException {
		return modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}

}
