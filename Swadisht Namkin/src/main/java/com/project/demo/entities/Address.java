package com.project.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User_Address")
@NoArgsConstructor
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;

	private String addressLane1;
	
	private String addressLane2;
	
	private String landMark;
	
	private String city;
	
	private String country;
	
	private long postCode;
	
	 @Column(name = "phone_number")
	 private String phoneNumber;
	
	@ManyToOne
	private LocalUser localUser;
	
}
