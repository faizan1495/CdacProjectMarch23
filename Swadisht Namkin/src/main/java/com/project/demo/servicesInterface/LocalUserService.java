package com.project.demo.servicesInterface;

import java.util.List;

import com.project.demo.payloads.LocalUserDto;


public interface LocalUserService {

	LocalUserDto createUser(LocalUserDto user);

	LocalUserDto updateUser(LocalUserDto user, String userId);

	LocalUserDto getUserById(String userId);

	List<LocalUserDto> getAllUsers();

	void deleteUser(String userId);

}
