package com.piseth.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.model.Model;

@Mapper
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand" , source = "brandDTO")
	Model toModel(ModelDTO dto);
	
	@Mapping(target = "brandDTO" , source = "brand")
	ModelDTO toDTO(Model entity);
	
	
	
	
}
