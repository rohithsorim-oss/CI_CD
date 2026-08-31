package com.rohith.cicdDemo.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLogoutResponse {
    @NotBlank
    String message;
}
