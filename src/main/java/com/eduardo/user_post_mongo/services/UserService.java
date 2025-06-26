package com.eduardo.user_post_mongo.services;

import com.eduardo.user_post_mongo.models.dtos.UserDTO;
import com.eduardo.user_post_mongo.models.entities.User;
import com.eduardo.user_post_mongo.repositories.UserRepository;
import com.eduardo.user_post_mongo.services.exceptions.ResourceNotFoundException;
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

    public UserDTO findById(String id) {
        User user = repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Usuário do id %d não foi encontrado!", id)));
        return new UserDTO(user);
    }
}
