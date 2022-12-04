package com.piseth.java.school.phoneshop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{cannot.be.blank}")
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

	@NotNull(message = "{required.field}")
	@Column(name = "year_made")
	private Short yearMade;

	/*
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
*/
	
	@DecimalMin(value = "0.000001")
	@Column(name = "import_price")
	private BigDecimal importPrice;

	@Column(name = "sale_price")
	private Double salePrice;

	@Column(name = "date_import")
	private LocalDateTime dateImport;

	// private Integer numberOfUnit; // @TODO should move to Stock table? reason?

	@Column(name = "image_path")
	private String imagePath;

}
