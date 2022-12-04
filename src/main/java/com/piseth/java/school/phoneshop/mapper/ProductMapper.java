package com.piseth.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piseth.java.school.phoneshop.dto.ProductDTO;
import com.piseth.java.school.phoneshop.model.Product;
import com.piseth.java.school.phoneshop.service.ModelService;

@Mapper(componentModel = "spring", uses = {ModelService.class} )
public interface ProductMapper {
	@Mapping(target = "model", source = "dto.modelId")
	Product toProduct(ProductDTO dto);

	@Mapping(target = "modelId", source = "model.id")
	ProductDTO toDTO(Product entity);
}
