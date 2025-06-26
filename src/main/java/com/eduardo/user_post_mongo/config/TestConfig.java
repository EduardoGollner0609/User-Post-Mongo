package com.eduardo.user_post_mongo.config;

import com.eduardo.user_post_mongo.models.entities.User;
import com.eduardo.user_post_mongo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.deleteAll();

        User userEduardo = new User(null, "Eduardo", "eduardo@gmail.com");
        User userJose = new User(null, "José", "josé@gmail.com");
        User userRaphael = new User(null, "Raphael", "raphael@gmail.com");

        userRepository.saveAll(Arrays.asList(userEduardo, userJose, userRaphael));
    }

}
