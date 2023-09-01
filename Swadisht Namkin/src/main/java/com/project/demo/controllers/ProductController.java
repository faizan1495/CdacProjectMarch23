package com.project.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.payloads.ApiResponse;
import com.project.demo.payloads.ProductDto;
import com.project.demo.servicesInterface.ProductService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/users/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//post-create product
		@PostMapping("/insertdata")
		public ResponseEntity<ProductDto> createProduct( @RequestBody ProductDto productDto) {
				ProductDto productDto2 = this.productService.createProduct(productDto);
			return new ResponseEntity<>(productDto2, HttpStatus.CREATED);
		}
		
		//put-update product
		@PutMapping("/{productId}")
		public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("productId") Long pid) {
			ProductDto updateProduct = this.productService.updateProduct(productDto, pid);
			return ResponseEntity.ok(updateProduct);
		}
		
		//delete-delete product
		@DeleteMapping("/{productId}")
		public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") Long pid) {
			this.productService.deleteProduct(pid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("product deleted..", true), HttpStatus.OK);
		}
		
		//get- get Allproduct
		@GetMapping("/all")
		public ResponseEntity<List<ProductDto>> getproduct() {
			return ResponseEntity.ok(this.productService.getproduct());
		}
		
		//get- get productById
		@GetMapping("/{productId}")
		public ResponseEntity<ProductDto> getSingleproduct(@PathVariable Long productId) {
			return ResponseEntity.ok(this.productService.getProductById(productId));
		}

}
