package com.project.demo.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.LocalUser;
import com.project.demo.exception.ResourceNotFoundException;
import com.project.demo.payloads.LocalUserDto;
import com.project.demo.repositories.LocalUserRepo;
import com.project.demo.servicesInterface.LocalUserService;

@Service
public class UserServiceImpl implements LocalUserService {

	@Autowired
	private LocalUserRepo localUserRepo;

	@Autowired
	private ModelMapper modelMapper;

//	@Override
//	public LocalUserDto createUser(LocalUserDto user) {
//		LocalUser user1 = this.dtoToLocalUser(user);
//		LocalUser savedUser = this.LocalUserRepo.save(user1);
//		return this.userToDto(savedUser);
//	}
	@Override
	public LocalUserDto createUser(LocalUserDto user) {
		LocalUser userLocalUser = this.dtoToUser(user);
		LocalUser savedUser = this.localUserRepo.save(userLocalUser);
		return this.userToDto(savedUser);
	}

	@Override
	public LocalUserDto updateUser(LocalUserDto userDto, String userId) {
		LocalUser user = this.localUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setUserNameId(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		user.setEncryptedPassword(userDto.getEncryptedPassword());

		LocalUser updatedUser = this.localUserRepo.save(user);
		LocalUserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public LocalUserDto getUserById(String userId) {

		LocalUser user = this.localUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<LocalUserDto> getAllUsers() {
		List<LocalUser> users = this.localUserRepo.findAll();
		List<LocalUserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(String userId) {
		LocalUser user = this.localUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id",userId));
		this.localUserRepo.delete(user);

	}
	// to convert data...
	private LocalUser dtoToUser(LocalUserDto userDto) {
		LocalUser user = this.modelMapper.map(userDto, LocalUser.class);
		return user;
	}

	public LocalUserDto userToDto(LocalUser user) {
		LocalUserDto userDto = this.modelMapper.map(user, LocalUserDto.class);
		return userDto;
	}

//	@Override
//	public LocalUserDto updateUser(LocalUserDto user, Integer userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
