package com.rohith.cicdDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLogoutRequest {
    @NotBlank
    @Email
    String mail;
}
