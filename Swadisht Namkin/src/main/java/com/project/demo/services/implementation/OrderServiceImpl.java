package com.project.demo.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.Address;
import com.project.demo.entities.Order;
import com.project.demo.exception.ResourceNotFoundException;
import com.project.demo.payloads.AddressDto;
import com.project.demo.payloads.OrderDto;
import com.project.demo.repositories.OrderRepo;
import com.project.demo.servicesInterface.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo  orderrepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderDto createOrder(OrderDto orderDtos) {
		Order orderOrder = this.dtoToorder(orderDtos);
		Order savedOreder = this.orderrepo.save(orderOrder);
		return this.orderToDto( savedOreder);
	}
	
	@Override
	public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
		Order order1 = this.orderrepo.findById(orderId)
				.orElseThrow(()-> new ResourceNotFoundException("Order", "OrderId", orderId));
		order1.setProducts(orderDto.getProduct());
		order1.setQuantity(orderDto.getQuantity());
		order1.setAddress(orderDto.getAddress());
		order1.setTotalAmount(orderDto.getAmount());
		order1.setUser(orderDto.getUser());
		order1.setDate(orderDto.getDate());
		
		
		Order updatedOrder = this.orderrepo.save(order1);
		OrderDto orderDto1 = this.orderToDto(updatedOrder);
		return  orderDto1;
	}
	

	@Override
	public OrderDto getOrderById(Integer orderId) {
		Order order = this.orderrepo.findById(orderId)
				.orElseThrow(()-> new ResourceNotFoundException("Order", "OrderId", orderId));
		return this.orderToDto(order);
	}

	@Override
	public List<OrderDto> getorder() {
		List<Order>order=this.orderrepo.findAll();
		List<OrderDto> orderDtos = order.stream().map(order1 -> this.orderToDto(order1)).collect(Collectors.toList());
		return orderDtos;
	}
	
//	Address address = this.addressRepo.findById(addressId)
//			.orElseThrow(()-> new ResourceNotFoundException("Address", "AddressId", addressId));
//	this.addressRepo.delete(address);

	@Override
	public void deleteOrder(Integer orderId) {
		Order order = this.orderrepo.findById(orderId)
				.orElseThrow(()-> new ResourceNotFoundException("Order", "OrderId", orderId));
		this.orderrepo.delete(order);

	}
	
	// to convert data...
		private Order dtoToorder(OrderDto orderDto) {
			Order order = this.modelMapper.map(orderDto, Order.class);
			return order;
		}

		public OrderDto orderToDto(Order order) {
			OrderDto orderDto = this.modelMapper.map(order, OrderDto.class);
			return orderDto;
		}


}
