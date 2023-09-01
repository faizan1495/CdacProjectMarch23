package com.project.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.payloads.ApiResponse;
import com.project.demo.payloads.LocalUserDto;
import com.project.demo.servicesInterface.LocalUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:3000")
public class LocalUserController {

	@Autowired
	private LocalUserService userService;

	//post-create user
			@PostMapping("/registion")
			public ResponseEntity<LocalUserDto> createUser(@Valid @RequestBody LocalUserDto userDto) {
				LocalUserDto createUserDto = this.userService.createUser(userDto);
				return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
			}
			
//	//login validation
//	@PostMapping("/loginvalidate")
//	public String loginUser(@ModelAttribute ("user") LocalUserDto localUserDto) {
//		Integer userid=localUserDto.getUserId();
//		Optional<LocalUserDto> userdata=Optional.of(this.userService.getUserById(userid));
//		if(localUserDto.getEncryptedPassword().equals(userdata.get().getEncryptedPassword()))
//		{
//			return"home";
//		}
//		else {
//			return "error";
//		}
//	}
	
////post-create user
//	@PostMapping("/registion")
//	public ResponseEntity<LocalUserDto> createUser(@Valid @RequestBody LocalUserDto userDto) {
//		LocalUserDto createUserDto = this.userService.createUser(userDto);
//		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
//
//	}

//put-update user
	@PutMapping("/{userId}")
	public ResponseEntity<LocalUserDto> updateUser(@Valid @RequestBody LocalUserDto userDto, @PathVariable("userId") String uid) {
		LocalUserDto updateUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);

	}

//delete-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") String uid) {
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted..", true), HttpStatus.OK);
	}

//get- get user
	@GetMapping("/users")
	public ResponseEntity<List<LocalUserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

//get- get user
	@GetMapping("/{userId}")
	public ResponseEntity<LocalUserDto> getSingleUsers(@PathVariable String userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
