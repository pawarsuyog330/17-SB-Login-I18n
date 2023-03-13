package com.ashokit.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_LOGIN")
public class LoginEntity {

	@Id
	private String username;
	
	private String password;
	
	private String status;
}
