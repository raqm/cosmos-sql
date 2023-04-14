package com.theraqs.cosmossql.controller;

import com.theraqs.cosmossql.model.User;
import com.theraqs.cosmossql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class CosmosSqlController {
    private final UserRepository userRepository;

    @GetMapping ("/users")
    Flux<User> getAllUsers(){
        return userRepository.findAll();
    }
}
