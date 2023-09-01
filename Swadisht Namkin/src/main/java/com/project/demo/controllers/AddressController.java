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
import com.project.demo.servicesInterface.AddressService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/Address")
//@CrossOrigin("localhost:3000")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	//post-create address
		@PostMapping("/insert")
		public ResponseEntity<AddressDto> createAddress(@Valid @RequestBody AddressDto addressDto) {
			AddressDto addressDto2 = this.addressService.createAddress(addressDto);
			return new ResponseEntity<>(addressDto2, HttpStatus.CREATED);
		}
		
		//put-update address
		@PutMapping("/{addressId}")
		public ResponseEntity<AddressDto> updateAddress(@Valid @RequestBody AddressDto addressDto, @PathVariable("addressId") Integer aid) {
			AddressDto updateAddress = this.addressService.updateAddress(addressDto, aid);
			return ResponseEntity.ok(updateAddress);
		}
		
		//delete-delete address
		@DeleteMapping("/{addressId}")
		public ResponseEntity<ApiResponse> deleteAddress(@PathVariable("addressId") Integer aid) {
			this.addressService.deleteAddress(aid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("address deleted..", true), HttpStatus.OK);
		}
		
		//get- get Alladdress
		@GetMapping("/")
		public ResponseEntity<List<AddressDto>> getaddress() {
			return ResponseEntity.ok(this.addressService.getadress());
		}
		
		//get- get addressById
		@GetMapping("/{addressId}")
		public ResponseEntity<AddressDto> getSingleAddress(@PathVariable Integer addressId) {
			return ResponseEntity.ok(this.addressService.getAddressById(addressId));
		}
}
