package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginModel {

    @NotBlank(message = "Username cannot be empty.")
    private String userName;

    @NotBlank(message = "Password cannot be empty.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Password should contain alpha numeric values")
    private String password;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
