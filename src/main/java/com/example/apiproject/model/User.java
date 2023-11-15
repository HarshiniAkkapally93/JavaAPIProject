package com.example.apiproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
@Schema(name="User", description = "User details")
public class User {
    @Schema(name="user id", example = "123" )
    private Long id;
    @Schema(name="user name", example = "harsh" )
    private String name;
    @Schema(name="user email", example = "harsh@gmail.com" )
    private String email;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
