package com.project.demo.servicesInterface;


import java.util.List;

import com.project.demo.payloads.AddressDto;


public interface AddressService {
	AddressDto createAddress(AddressDto address);

	AddressDto updateAddress(AddressDto address, Integer addressId);

	AddressDto getAddressById(Integer addressId);

	List<AddressDto> getadress();

	void deleteAddress(Integer addressId);

}
