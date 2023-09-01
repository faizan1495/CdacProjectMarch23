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

import com.project.demo.payloads.AddressDto;
import com.project.demo.payloads.ApiResponse;
import com.project.demo.payloads.OrderDto;
import com.project.demo.servicesInterface.AddressService;
import com.project.demo.servicesInterface.OrderService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/order")
@CrossOrigin("localhost:3000")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//post-create order
		@PostMapping("/insertoder")
		public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
			OrderDto orderDto2 = this.orderService.createOrder(orderDto);
			return new ResponseEntity<>(orderDto2, HttpStatus.CREATED);
		}
		
		//put-update order
		@PutMapping("/{orderId}")
		public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable("orderId") Integer aid) {
			OrderDto updateOrder = this.orderService.updateOrder(orderDto, aid);
			return ResponseEntity.ok(updateOrder);
		}
		
		//delete-delete order
		@DeleteMapping("/{orderId}")
		public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Integer aid) {
			this.orderService.deleteOrder(aid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("order deleted..", true), HttpStatus.OK);
		}
		
		//get- get Allorder
		@GetMapping("/")
		public ResponseEntity<List<OrderDto>> getorder() {
			return ResponseEntity.ok(this.orderService.getorder());
		}
		
		//get- get orderById
		@GetMapping("/{orderId}")
		public ResponseEntity<OrderDto> getSingleOrder(@PathVariable Integer orderId) {
			return ResponseEntity.ok(this.orderService.getOrderById(orderId));
		}

}
