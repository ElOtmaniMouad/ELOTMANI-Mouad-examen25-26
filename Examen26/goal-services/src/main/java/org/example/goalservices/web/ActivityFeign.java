package org.example.goalservices.web;

    import org.example.goalservices.modele.Activity;
    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    import java.util.List;

@FeignClient(name="ACTIVITY-SERVICE")

public interface ActivityFeign {

    @GetMapping("/activities")
    List<Activity> getActivities();

    @GetMapping("/activities/{id}")
    Activity getActivity(@PathVariable Long id);

}

