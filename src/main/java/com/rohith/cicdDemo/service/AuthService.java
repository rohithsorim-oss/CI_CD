package com.rohith.cicdDemo.service;

import com.rohith.cicdDemo.dto.UserRegisterRequest;
import com.rohith.cicdDemo.dto.UserRegisterResponse;
import com.rohith.cicdDemo.entity.User;
import com.rohith.cicdDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = Exception.class)
    public UserRegisterResponse register(UserRegisterRequest registerRequest) throws Exception {
        if(userRepository.findByMail(registerRequest.getMail()).isPresent()) {
            throw new Exception("User Already Registered");
        }
        User user = new User();
        user.setFavoriteFood(registerRequest.getFavoriteFood());
        user.setName(registerRequest.getName());
        user.setMail(registerRequest.getMail());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        user = userRepository.save(user);
        return new UserRegisterResponse("User Created, ID: " + user.getId());
    }

}
