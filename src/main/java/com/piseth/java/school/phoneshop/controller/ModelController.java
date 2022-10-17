package com.piseth.java.school.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.mapper.ModelMapper;
import com.piseth.java.school.phoneshop.model.Model;
import com.piseth.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO dto){
		Model model = modelService.save(dto);
		ModelDTO modelDTO = ModelMapper.INSTANCE.toDTO(model);
		return ResponseEntity.ok(modelDTO);
	}

}
