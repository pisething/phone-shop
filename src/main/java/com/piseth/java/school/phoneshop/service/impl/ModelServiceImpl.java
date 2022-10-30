package com.piseth.java.school.phoneshop.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop.mapper.ModelMapper;
import com.piseth.java.school.phoneshop.model.Model;
import com.piseth.java.school.phoneshop.repository.ModelRepository;
import com.piseth.java.school.phoneshop.service.BrandService;
import com.piseth.java.school.phoneshop.service.ModelService;
import com.piseth.java.school.phoneshop.spec.ModelFilter;
import com.piseth.java.school.phoneshop.spec.ModelSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService{
	
	private final ModelRepository modelRepository;
	
	private final BrandService brandService;

	@Override
	public Model save(ModelDTO dto)  {
		
		Integer brandId = dto.getBrandDTO().getId();
		brandService.getById(brandId);
		
		Model model = ModelMapper.INSTANCE.toModel(dto);
		return modelRepository.save(model);
	}

	@Override
	public Model getById(Integer id)  {
		return modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}
	
	@Override
	public List<Model> getModels(Map<String, String> params) {
		ModelFilter modelFilter = new ModelFilter();
		if(params.containsKey("modelId")) {
			modelFilter.setModelId(MapUtils.getInteger(params, "modelId"));
		}
		if(params.containsKey("modelName")) {
			modelFilter.setModelName(MapUtils.getString(params, "modelName"));
		}
		if(params.containsKey("brandId")) {
			modelFilter.setBrandId(MapUtils.getInteger(params, "brandId"));
		}
		if(params.containsKey("brandName")) {
			modelFilter.setBrandName(MapUtils.getString(params, "brandName"));
		}
		
		ModelSpec modelSpec = new ModelSpec(modelFilter);
		return modelRepository.findAll(modelSpec, Sort.by(Order.asc("id")));
	}

	public List<Model> getModelsOld(Map<String, String> params) {
		/*
		Specification<Model> specification = new Specification<Model>() {
			
			@Override
			public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(params.containsKey("name")) {
					String modelName = params.get("name");
					Predicate predicateName = cb.like(model.get("name"), "%"+modelName + "%");
					return predicateName;
				}
				
				return null;
			}
		};
		*/
		Specification<Model> specification = (model,  query, cb) ->{
			if(params.containsKey("name")) {
				String modelName = params.get("name");
				Predicate predicateName = cb.like(model.get("name"), "%"+modelName + "%");
				return predicateName;
			}
			
			return null;
		};
		List<Model> list = modelRepository.findAll(specification, Sort.by(Order.asc("id")));
		return list;
	}

}
