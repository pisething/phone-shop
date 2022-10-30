package com.piseth.java.school.phoneshop.service;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.model.Model;

public interface ModelService {
	Model save(ModelDTO dto);
	Model getById(Integer id);
}
