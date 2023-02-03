package com.piseth.java.school.phoneshop.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop.model.SaleDetail;
import com.piseth.java.school.phoneshop.projections.SaleByDate;
import com.piseth.java.school.phoneshop.repository.SaleDetailRepository;
import com.piseth.java.school.phoneshop.service.ReportingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportingServiceImpl implements ReportingService{
	private final SaleDetailRepository saleDetailRepository;
	
	@Override
	public List<SaleByDate> getProductSoldByDate(LocalDate soldDate) {
		return saleDetailRepository.findByProduct(soldDate);
	}

	@Override
	public List<SaleDetail> getProductSoldByDateV2(LocalDate soldDate) {
		return null;
	}

}
