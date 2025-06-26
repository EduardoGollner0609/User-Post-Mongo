package com.eduardo.user_post_mongo.controllers;

import com.eduardo.user_post_mongo.models.dtos.PostDTO;
import com.eduardo.user_post_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> getPostsByTitle(@RequestParam(name = "text", defaultValue = "") String title) {
        List<PostDTO> posts = service.getPostsByTitle(title);
        return ResponseEntity.ok(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(name = "text", defaultValue = "") String title,
            @RequestParam(name = "start", defaultValue = "") String start,
            @RequestParam(name = "end", defaultValue = "") String end) {
        List<PostDTO> posts = service.fullSearch(title, start, end);
        return ResponseEntity.ok(posts);
    }
}
