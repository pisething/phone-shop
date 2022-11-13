package com.piseth.java.school.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.piseth.java.school.phoneshop.exception.ApiException;
import com.piseth.java.school.phoneshop.model.Brand;
import com.piseth.java.school.phoneshop.repository.BrandRepository;
import com.piseth.java.school.phoneshop.service.impl.BrandServiceImpl;
@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void setup() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	
	//@Test
	public void testSavebrandOld() {
		
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		//when
	
		when(brandRepository.save(any(Brand.class))).thenAnswer(new Answer<Brand>() {

			@Override
			public Brand answer(InvocationOnMock invocation) throws Throwable {
				Brand brandEntity =  invocation.getArgument(0);
				brandEntity.setId(1);
				return brandEntity;
			}
			
		});
		
		/*
		when(brandRepository.save(any(Brand.class))).thenAnswer(invocation ->{
			Brand brandEntity =  invocation.getArgument(0);
			brandEntity.setId(1);
			return brandEntity;
		});
		*/
		
		
		//then
		Brand brandReturn = brandService.save(brand);
		assertEquals("Apple", brandReturn.getName());
		assertEquals(1, brandReturn.getId());
	}
	
	@Test
	public void testSavebrand() {
		
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brandReturn = brandService.save(brand);
		
		//then
		verify(brandRepository, times(1)).save(brand);
		
	}
	
	@Test
	public void getByIdSuccess() {
		//given
		Brand brand = new Brand(1, "Apple");
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		
		
		//then
		Brand brandReturn = brandService.getById(1);
		assertNotNull(brandReturn);
		assertEquals("Apple", brandReturn.getName());
		assertEquals(1, brandReturn.getId());
	}
	
	@Test
	public void getByIdThrowException() {
		
		//given
		
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		
		//then
		
		assertThatThrownBy(() -> brandService.getById(2))
		.isInstanceOf(ApiException.class)
		.hasMessageStartingWith("brand not found for id=");
			
	}

}

