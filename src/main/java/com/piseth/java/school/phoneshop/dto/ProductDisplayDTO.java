package com.piseth.java.school.phoneshop.dto;

import lombok.Data;

@Data
public class ProductDisplayDTO {
	private Long id;
	private String name;
	private String model;
	private String color;
	private Double salePrice;
}
