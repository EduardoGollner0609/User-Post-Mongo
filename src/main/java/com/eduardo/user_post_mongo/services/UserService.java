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
        User user = getEntityById(id);
        return new UserDTO(user);
    }

    public UserDTO create(UserDTO userDTO) {
        User user = new User();
        copyDtoToEntity(user, userDTO);
        return new UserDTO(repository.insert(user));
    }

    public UserDTO update(String id, UserDTO userDTO) {
        User user = getEntityById(id);
        copyDtoToEntity(user, userDTO);
        return new UserDTO(repository.save(user));
    }

    private User getEntityById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Usuário do id %s não foi encontrado!", id)));
    }

    private void copyDtoToEntity(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
    }
}
