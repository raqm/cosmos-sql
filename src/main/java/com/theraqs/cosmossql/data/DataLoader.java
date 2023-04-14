package com.theraqs.cosmossql.data;

import com.theraqs.cosmossql.model.User;
import com.theraqs.cosmossql.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@AllArgsConstructor
public class DataLoader {
    private final UserRepository userRepository;

    @PostConstruct
    void loadData() {
        userRepository.deleteAll()
                .thenMany(Flux.just(new User("1","Alpha","Bravo","124 4th St")))
                .flatMap(userRepository::save)
                .thenMany(userRepository.findAll())
                .subscribe(user -> log.info(user.toString()));
    }
}
