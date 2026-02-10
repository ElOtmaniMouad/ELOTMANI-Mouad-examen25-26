package org.example.activiteservice.web;

import org.example.activiteservice.entities.Activity;
import org.example.activiteservice.repositories.ActivityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class ActivityController {
    ActivityRepository ActivityRepository;
    public ActivityController(ActivityRepository UserRepository) {
        this.ActivityRepository = UserRepository;
    }

    @GetMapping("/activities")
    public List<Activity> findAll(){
        return ActivityRepository.findAll();
    }

    @GetMapping("/activities/{id}")
    public Activity findById(@PathVariable Long id){
        return ActivityRepository.findById(id).get();
    }

}