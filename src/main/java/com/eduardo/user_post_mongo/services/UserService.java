package com.eduardo.user_post_mongo.services;

import com.eduardo.user_post_mongo.models.dtos.UserDTO;
import com.eduardo.user_post_mongo.models.entities.User;
import com.eduardo.user_post_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}
