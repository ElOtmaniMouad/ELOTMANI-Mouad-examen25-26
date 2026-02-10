package org.example.goalservices.web;

import org.example.goalservices.entities.Goal;
import org.example.goalservices.modele.Activity;
import org.example.goalservices.modele.User;
import org.example.goalservices.repositories.GoalRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class GoalController {

    final private ActivityFeign  activityFeign;
    final  private UserFeign userFeign;

    public GoalController(ActivityFeign activityFeign, UserFeign userFeign, GoalRepository goalRepository) {
        this.activityFeign = activityFeign;
        this.userFeign = userFeign;
        this.goalRepository = goalRepository;
    }

    final GoalRepository goalRepository;


    @GetMapping("/goals")
    public List<Goal> getGoals () {
        List<Activity> activities = activityFeign.getActivities();


        List<User>  users = userFeign.getUsers();
        List<Goal> goals = goalRepository.findAll();

        //List<Goal> liste=new ArrayList<>();

        for (Goal em : goals) {

            for (User e : users)
                if  (e.getIdUser()==em.getIdUser())
                {em.setUser(e);
                    break;}

            for (Activity l : activities)
                if (em.getIdActivity()== l.getIdActivity())
                { em.setActivity(l);
                    break;}

        }


        return goals;

    }

    @GetMapping("/goals/{id}")
    public Goal getGoal (@PathVariable("id") Long id) {

        Goal goal = goalRepository.findById(id).get();

        Activity activity = activityFeign.getActivity(goal.getIdActivity());

        User user = userFeign.getUser(goal.getIdUser());

        goal.setUser(user);
        goal.setActivity(activity);

        return goal;
    }



}
