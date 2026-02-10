package org.example.goalservices.repositories;

import org.example.goalservices.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository  extends JpaRepository<Goal, Long> {
}
