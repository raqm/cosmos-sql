package com.theraqs.cosmossql.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.theraqs.cosmossql.model.User;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCosmosRepository<User, String>{
    Flux<User> findByFirstName(String firstName);
}
