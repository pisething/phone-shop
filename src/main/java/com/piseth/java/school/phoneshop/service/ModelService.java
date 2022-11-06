package com.piseth.java.school.phoneshop.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.model.Model;

public interface ModelService {
	Model save(ModelDTO dto);
	Model getById(Integer id);
	Page<Model> getModels(Map<String, String> params);
}
