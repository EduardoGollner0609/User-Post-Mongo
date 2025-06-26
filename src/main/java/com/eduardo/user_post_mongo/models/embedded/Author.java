package com.eduardo.user_post_mongo.models.embedded;

import com.eduardo.user_post_mongo.models.entities.User;

public class Author {

    private String id;
    private String name;

    public Author() {
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
