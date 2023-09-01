package com.project.demo.payloads;


import java.sql.Date;
import java.util.List;

import com.project.demo.entities.Address;
import com.project.demo.entities.LocalUser;
import com.project.demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class OrderDto {
	
	private int orderId;
	
	private LocalUser user;
	
    private List<Product> product;
	  
	private Address address;
	
	private int quantity;
	
	private double amount;
	
	private Date date;



}
