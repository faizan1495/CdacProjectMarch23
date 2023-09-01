package com.project.demo.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LocalUserDto {
	@NotEmpty
	@Size(min=3,message="name should be more then 3 letters..")
	private String userNameId;
	
	@Email(message="Email is not valid..")
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="password between  3 to 10 letters")
	private String encryptedPassword;
	

	

}
