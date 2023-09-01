package com.project.demo.servicesInterface;

import java.util.List;

import com.project.demo.payloads.OrderDto;


public interface OrderService {

	OrderDto createOrder(OrderDto orderDto);

	OrderDto updateOrder(OrderDto order, Integer orderId);

	OrderDto getOrderById(Integer orderId);

	List<OrderDto> getorder();

	void deleteOrder(Integer orderId);
}
