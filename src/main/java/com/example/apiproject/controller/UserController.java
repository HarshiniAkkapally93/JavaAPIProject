package com.example.apiproject.controller;

import com.example.apiproject.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
@Tag(description="User Api Project", name="userApiProject")
public class UserController {

    private List<User> users = new ArrayList<>();

    @RequestMapping(value="/getUser", method=RequestMethod.GET)
    @Operation(summary = "Get all the Users", description="Get Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all Users"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    @Operation(summary = "Add User passed", description="Add Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Add User"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> createUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok("Added Successfully");
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
        }

        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
