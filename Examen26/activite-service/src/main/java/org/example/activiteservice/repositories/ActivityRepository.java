package org.example.activiteservice.repositories;

import org.example.activiteservice.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActivityRepository  extends JpaRepository<Activity, Long> {
}