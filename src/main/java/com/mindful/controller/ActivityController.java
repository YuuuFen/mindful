package com.mindful.controller;

import com.mindful.model.Activity;
import com.mindful.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity createdActivity = activityService.createActivity(activity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable UUID id) {
        Activity activity = activityService.getActivityById(id);
        return activity != null ? new ResponseEntity<>(activity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable UUID id, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.updateActivity(id, activity);
        return updatedActivity != null ? new ResponseEntity<>(updatedActivity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable UUID id) {
        boolean deleted = activityService.deleteActivity(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}