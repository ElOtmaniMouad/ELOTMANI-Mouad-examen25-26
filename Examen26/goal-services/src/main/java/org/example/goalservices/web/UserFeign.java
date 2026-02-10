package org.example.goalservices.web;

import org.example.goalservices.modele.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="USER-SERVICE")

public interface UserFeign {

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);

}