package com.project.demo.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.Product;
import com.project.demo.exception.ResourceNotFoundException;
import com.project.demo.payloads.ProductDto;
import com.project.demo.repositories.ProductRepo;
import com.project.demo.servicesInterface.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ModelMapper modelMapper;
	


	@Override
	public ProductDto createProduct(ProductDto product) {
		Product productProduct = this.dtoToProduct(product);
		Product savedProduct = this.productRepo.save(productProduct);
		return this.productToDto(savedProduct);
	}
	
	@Override
	public ProductDto updateProduct(ProductDto productDto, Long productId) {
		Product product1 = this.productRepo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product","ProductId", productId));
		product1.setId(productDto.getId());
		product1.setTitle(productDto.getTitle());
		product1.setCat(productDto.getCat());
		product1.setImg(productDto.getImg());
		product1.setPrice(productDto.getPrice());
		
		
		Product updatedproduct = this.productRepo.save(product1);
		ProductDto productDto1 = this.productToDto(updatedproduct);
		return productDto1;
	}
	

	@Override
	public ProductDto getProductById(Long productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product", "ProductId", productId));
		return this.productToDto(product);
	}
	

	@Override
	public List<ProductDto> getproduct() {
		List<Product>products=this.productRepo.findAll();
		List<ProductDto> productDtos = products.stream().map(product ->this.productToDto(product)).collect(Collectors.toList());
		return productDtos;
	}
	
	@Override
	public void deleteProduct(Long productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Product","ProductId", productId));
		this.productRepo.delete(product);

	}

	// to convert data...
		private Product dtoToProduct(ProductDto productDto) {
			Product product = this.modelMapper.map(productDto, Product.class);
			return product;
		}

		public ProductDto productToDto(Product product) {
			ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
			return productDto;
		}

}
