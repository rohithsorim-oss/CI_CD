package com.rohith.cicdDemo.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginResponse {
    @NotBlank
    String message;
}
