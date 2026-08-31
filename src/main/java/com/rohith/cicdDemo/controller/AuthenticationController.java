package com.rohith.cicdDemo.controller;

import com.rohith.cicdDemo.dto.UserRegisterRequest;
import com.rohith.cicdDemo.dto.UserRegisterResponse;
import com.rohith.cicdDemo.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth/")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) throws Exception {
        UserRegisterResponse userRegisterResponse = authService.register(userRegisterRequest);
        return new ResponseEntity<>(userRegisterResponse, HttpStatus.CREATED);
    }
}
