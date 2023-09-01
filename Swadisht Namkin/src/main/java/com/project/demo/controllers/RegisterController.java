package com.project.demo.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.LocalUser;
import com.project.demo.payloads.LocalUserDto;
import com.project.demo.repositories.LocalUserRepo;
import com.project.demo.servicesInterface.LocalUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping()
public class RegisterController {

	@Autowired
	private LocalUserService userService;

	@Autowired
	private LocalUserRepo localUserRepo;
	
	//login form
		@GetMapping("/form")
		public String loginForm(Model model)
		{
			LocalUserDto localUserDto=new LocalUserDto();
			model.addAttribute("LocalUserDto", localUserDto);
			System.out.println(localUserDto.toString());
			return "form";
		}
		//post-create user
		@PostMapping("/registion")
		public ResponseEntity<LocalUserDto> createUser(@Valid @RequestBody LocalUserDto userDto) {
			LocalUserDto createUserDto = this.userService.createUser(userDto);
			return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		}
		//login validation
		@PostMapping("/loginvalidate")
		public String loginUser(@ModelAttribute ("user") LocalUserDto localUserDto) {
			String userid=localUserDto.getUserNameId();
			System.out.println(localUserDto);
			Optional<LocalUserDto> userdata=Optional.of(this.userService.getUserById(userid));
			if(localUserDto.getEncryptedPassword().equals(userdata.get().getEncryptedPassword()))
			{
				return"home";
			}
			else {
				return "error";
			}
		}

}
