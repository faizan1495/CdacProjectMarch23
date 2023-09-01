package com.project.demo.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.Address;
import com.project.demo.exception.ResourceNotFoundException;
import com.project.demo.payloads.AddressDto;
import com.project.demo.repositories.AddressRepo;
import com.project.demo.servicesInterface.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressDto createAddress(AddressDto address) {
		Address addressAddress = this.dtoToAddress(address);
		Address savedAddress = this.addressRepo.save(addressAddress);
		return this.addressToDto(savedAddress);
	}


	@Override
	public AddressDto updateAddress(AddressDto addressDto, Integer addressId) {
		Address address1 = this.addressRepo.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "AddressId", addressId));
		address1.setAddressLane1(addressDto.getAddressLane1());
		address1.setAddressLane2(addressDto.getAddressLane2());
		address1.setLandMark(addressDto.getLandMark());
		address1.setCity(addressDto.getCity());
		address1.setCountry(addressDto.getCountry());
		address1.setPostCode(addressDto.getPostCode());
		address1.setLocalUser(addressDto.getLocalUser());
		address1.setPhoneNumber(addressDto.getPhoneNumber());

		Address updatedAddress = this.addressRepo.save(address1);
		AddressDto addressDto1 = this.addressToDto(updatedAddress);
		return addressDto1;
	}

	
	@Override
	public AddressDto getAddressById(Integer addressId) {
		
		Address address = this.addressRepo.findById(addressId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "AddressId", addressId));
		
		return this.addressToDto(address);
	}
	
	@Override
	public List<AddressDto> getadress() {
		List<Address>address=this.addressRepo.findAll();
		List<AddressDto> addressDtos = address.stream().map(addres ->this.addressToDto(addres)).collect(Collectors.toList());
		return addressDtos;
	}


	@Override
	public void deleteAddress(Integer addressId) {
		
		Address address = this.addressRepo.findById(addressId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "AddressId", addressId));
		this.addressRepo.delete(address);

	}

	// to convert data...
	private Address dtoToAddress(AddressDto addressDto) {
		Address address = this.modelMapper.map(addressDto, Address.class);
		return address;
	}

	public AddressDto addressToDto(Address address) {
		AddressDto addressDto = this.modelMapper.map(address, AddressDto.class);
		return addressDto;
	}

}
