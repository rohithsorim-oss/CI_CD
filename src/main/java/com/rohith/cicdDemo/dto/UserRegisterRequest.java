package com.rohith.cicdDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterRequest {

    @NotBlank
    String name;
    @NotBlank
    @Email(message = "Email must be of valid type")
    String mail;
    @NotBlank
    @Size(min = 10, max = 10, message = "Phone numbers must be of size 10")
    String phone;
    @NotBlank(message = "Favorite Food must not be empty")
    String favoriteFood;
    @NotBlank
    String password;
}
