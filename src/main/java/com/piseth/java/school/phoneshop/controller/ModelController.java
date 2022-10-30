package com.piseth.java.school.phoneshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.exception.ApiException;
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
	public ResponseEntity<?> create(@RequestBody ModelDTO dto) throws ApiException{
		Model model = modelService.save(dto);
		ModelDTO modelDTO = ModelMapper.INSTANCE.toDTO(model);
		return ResponseEntity.ok(modelDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException{
		Model model = modelService.getById(id);
		return ResponseEntity.ok(ModelMapper.INSTANCE.toDTO(model));
	}
	
	@GetMapping
	public ResponseEntity<?> getModelList(@RequestParam Map<String, String> params){
		List<ModelDTO> list = modelService.getModels(params)
			.stream()
			.map(m -> ModelMapper.INSTANCE.toDTO(m))
			.toList();
		return ResponseEntity.ok(list);
	}

}
