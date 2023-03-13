package com.ashokit.mvc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginRequest {

	@NotEmpty
	private String username;
	
	@NotEmpty
	@Pattern(regexp="^[a-z][a-z0-9]*@[0-9]*")
	private String password;
}
