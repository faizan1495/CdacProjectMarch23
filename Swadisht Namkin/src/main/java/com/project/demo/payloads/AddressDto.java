package com.project.demo.payloads;


import com.project.demo.entities.LocalUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

	private int addressId;
	
	private String addressLane1;
	
	private String addressLane2;

	private String landMark;
	
	private String city;
	
	private String country;
	
	private long postCode;
	
	private String phoneNumber;
	
	private LocalUser localUser;
	
	
}
