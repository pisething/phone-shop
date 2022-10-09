package com.piseth.java.school.phoneshop.mapper;

import com.piseth.java.school.phoneshop.dto.BrandDTO;
import com.piseth.java.school.phoneshop.model.Brand;

public class EntityMapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getName());
		return brand;
	}
	
	public static BrandDTO toBrandDTO(Brand entity) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(entity.getName());
		return brandDTO;
	}
}
