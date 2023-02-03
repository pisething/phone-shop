package com.piseth.java.school.phoneshop.service;

import java.time.LocalDate;
import java.util.List;

import com.piseth.java.school.phoneshop.projections.SaleByDate;

public interface ReportingService {
// daily sale by product
	List<SaleByDate> getProductSoldByDate(LocalDate soldDate);

}
