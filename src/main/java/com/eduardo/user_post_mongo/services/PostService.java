package com.eduardo.user_post_mongo.services;

import com.eduardo.user_post_mongo.models.dtos.PostDTO;
import com.eduardo.user_post_mongo.models.entities.Post;
import com.eduardo.user_post_mongo.repositories.PostRepository;
import com.eduardo.user_post_mongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id) {
        Post post = getEntityById(id);
        return new PostDTO(post);
    }


    private Post getEntityById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Post do id %s não foi encontrado!", id)));
    }

    public List<PostDTO> getPostsByTitle(String title) {
        List<Post> posts = repository.findByTitleContainingIgnoreCase(title);
        return posts.stream().map(post -> new PostDTO(post)).toList();
    }
}
