package com.project.demo.servicesInterface;

import java.util.List;

import com.project.demo.payloads.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto product);

	ProductDto updateProduct(ProductDto product, Long productId);

	ProductDto getProductById(Long productId);

	List<ProductDto> getproduct();

	void deleteProduct(Long productId);

}
