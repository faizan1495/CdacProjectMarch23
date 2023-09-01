package com.project.demo.payloads;

import com.project.demo.entities.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
	
	
	
	private int Id;

	private String Title;
	
	private String Cat;

	private int Price;
	
	private String Img;
	
	

}
